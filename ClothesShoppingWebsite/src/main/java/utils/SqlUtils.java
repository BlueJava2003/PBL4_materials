package utils;

public class SqlUtils {
	private SqlUtils() {

	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

//	public static String md5(String password) {
//		Objects.requireNonNull(password, "password canot be null");
//		System.out.println(password + " --> " + DigestUtils.md5Hex(password));
//		return DigestUtils.md5Hex(password);
//	}
}
