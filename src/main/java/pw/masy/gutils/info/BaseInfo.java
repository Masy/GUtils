package pw.masy.gutils.info;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import oshi.SystemInfo;

/**
 * Class storing a {@link Runtime} and a {@link SystemInfo} instance.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseInfo {

	public static final Runtime RUNTIME = Runtime.getRuntime();
	public static final SystemInfo SYSTEM_INFO = new SystemInfo();

}
