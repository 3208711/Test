package org.lanqiao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutoCheckExamImpl implements AutoCheckExam {

	// 提交答案的文件夹地址
	private String answerPath = "//Users//David//Downloads//IO练习题//第一册";
	// 标准答案的文件地址
	private String standardPath = "//Users//David//Downloads//IO练习题//标准答案.txt";
	// 考试成绩文件地址
	private String resultPath = "//Users//David//Downloads//IO练习题//第一册考试成绩.txt";
	// 每道题的分数
	private double score = 5;

	@Override
	public File[] getFileUrlList(String path) throws Exception {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length > 0) {
				return files;
			} else {
				throw new Exception("该文件夹中没有文件。");
			}
		} else {
			throw new Exception("传入参数地址不存在。");
		}
	}

	@Override
	public String getStringFormFile(File file) {
		StringBuilder ret = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				ret.append(s);
				ret.append(",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret.toString();
	}

	/*
	 * 这里要考虑中英文逗号的问题，还有学生使用“、”等其他符号的情况。
	 */
	@Override
	public String[] getArrayFromString(String str) {
		return str.split(",");
	}

	@Override
	public int checkAnswer(String[] subAnswer, String[] stanAnswer) {
		int count = 0;
		// 若提交答案数量不正确，说明学生提交的答案错误。
		if (subAnswer.length == stanAnswer.length) {
			for (int i = 0; i < stanAnswer.length; i++) {
				if (subAnswer[i].equalsIgnoreCase(stanAnswer[i])) {
					count++;
				}
			}
		}
		return count;
	}

	public void run() {
		try {
			// 获得标准答案数组
			String[] stanAnswer = getArrayFromString(getStringFormFile(new File(standardPath)));
			// 获得指定路径的文件数组
			File[] files = getFileUrlList(answerPath);
			// 循环数组，依次处理每个提交答案。
			for (int i = 0; i < files.length; i++) {
				// 获得提交答案的数组
				String[] subAnswer = getArrayFromString(getStringFormFile(files[i]));
				// 依次比对答案，得到正确答案数量
				int count = checkAnswer(subAnswer, stanAnswer);
				// 获得文件名 -> 考生姓名 -》编号、考生姓名、成绩
				String outStr = (i + 1) + "\t" + files[i].getName() + "\t";
				outStr = (count == 0) ? outStr + "提交答案错误" : outStr + (count * score);
				outStr += "\r\n";
				// 输考试结果到指定文件
				writeFile(resultPath, outStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void writeFile(String path, String content) {

		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true));
			bufferedWriter.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new AutoCheckExamImpl().run();
	}
}
