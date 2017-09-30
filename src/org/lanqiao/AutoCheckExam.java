package org.lanqiao;
import java.io.File;

/**
 * @author David1
 * @version 1.0
 */
public interface AutoCheckExam {
	/**
	 * 循环遍历制定文件夹,得到提交答案的集合。
	 * 
	 * @param path
	 *            文件夹地址
	 * @return 该地址内所有的文件
	 * @throws Exception
	 * 
	 */
	public File[] getFileUrlList(String path) throws Exception;

	/**
	 * 读取文件夹中的指定文件，返回读取后的字符串。
	 * 
	 * @param file
	 *            需要处理的文件，包括提交答案和标准答案。
	 * @return 文档中的答案，需要做处理。
	 * 
	 */
	public String getStringFormFile(File file);

	/**
	 * 处理字符串，得到对应的数组。
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @return 处理后的字符串
	 * 
	 */
	public String[] getArrayFromString(String str);

	/**
	 * 提交答案和标准答案比对，返回结果。
	 * 
	 * @param subAnswer
	 *            提交答案
	 * @param stanAnswer
	 *            标准答案
	 * @return 正确答案数量
	 *
	 */
	public int checkAnswer(String subAnswer[], String stanAnswer[]);

	/**
	 * 将字符串输出到指定地址的文档。
	 * 
	 * @param path
	 *            文档地址
	 * @param content
	 *            文档内容
	 * 
	 */
	public void writeFile(String path, String content);
	/**
	 * 程序运行时的业务逻辑，在该方法中调用其他方法完成程序的业务逻辑。
	 * 
	 * */
	public void run();
}
