package pw.masy.gutils.info;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class storing information about the RAM of the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RamInfo extends BaseInfo {

	private static final double BYTES_TO_MB = 1024 * 1024;

	public static final double TOTAL_MEMORY = SYSTEM_INFO.getHardware().getMemory().getTotal() / BYTES_TO_MB;
	public static final double HEAP_SIZE = RUNTIME.maxMemory() / BYTES_TO_MB;
	@Getter private static double allocatedMemory;
	@Getter private static double usedMemory;

	static {
		update();
	}

	/**
	 * Updates the allocated and used memory information.
	 */
	public static void update() {
		allocatedMemory = RUNTIME.totalMemory() / BYTES_TO_MB;
		usedMemory = allocatedMemory - (RUNTIME.freeMemory() / BYTES_TO_MB);
	}

}
