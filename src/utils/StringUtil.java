package utils;

public final class StringUtil {
    public static final StringUtil INSTANCE = new StringUtil();

    private StringUtil() {
        // empty
    }

    /**
     * 替换指定字符串位置下的字符
     * @param str 待处理字符串
     * @param index 指定坐标
     * @param replacement 替换内容
     * @return 替换后结果
     */
    public String replaceCharAtIndex(String str, int index, char replacement) {
        if (str == null || index < 0 || index >= str.length()) {
            return str;
        }

        char[] chars = str.toCharArray();
        chars[index] = replacement;

        return new String(chars);
    }
}
