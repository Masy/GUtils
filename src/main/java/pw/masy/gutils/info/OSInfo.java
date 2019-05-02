package pw.masy.gutils.info;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class storing information about the operating system of the user.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OSInfo extends BaseInfo {

	public static final String JAVA_VENDOR = System.getProperty("java.vendor");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final OperatingSystem OS = getOperatingSystem();
	public static final String OS_NAME = SYSTEM_INFO.getOperatingSystem().getFamily();
	public static final String OS_ARCH = System.getProperty("os.arch");
	public static final String OS_VERSION = SYSTEM_INFO.getOperatingSystem().getVersion().getBuildNumber();
	public static final String OS_CODE_NAME = SYSTEM_INFO.getOperatingSystem().getVersion().getCodeName();
	public static final String OS_BUILD = SYSTEM_INFO.getOperatingSystem().getVersion().getBuildNumber();

	/**
	 * Gets the {@link OperatingSystem} of the user.
	 *
	 * @return the {@link OperatingSystem} of the user
	 */
	public static OperatingSystem getOperatingSystem() {
		String osName = System.getProperty("os.name");
		if (osName.contains("win")) return OperatingSystem.WINDOWS;
		if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) return OperatingSystem.UNIX;
		if (osName.contains("mac")) return OperatingSystem.MAC;
		return OperatingSystem.UNKNOWN;
	}

	/**
	 * Enum defining the operating system of a user.
	 */
	public enum OperatingSystem {
		WINDOWS,
		UNIX,
		MAC,
		UNKNOWN
	}

}
