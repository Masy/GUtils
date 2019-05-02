package pw.masy.gutils.info;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import oshi.hardware.CentralProcessor;

/**
 * Class storing information about the CPU of the user.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CPUInfo extends BaseInfo {

	public static final CentralProcessor CPU = SYSTEM_INFO.getHardware().getProcessor();
	public static final String CPU_NAME = CPU.getName();
	public static final int CPU_CORE_COUNT = CPU.getPhysicalProcessorCount();
	public static final int CPU_THREAD_COUNT = CPU.getLogicalProcessorCount();
	public static double CPU_LOAD_AVG;

	static {
		update();
	}

	/**
	 * Updates the cpu load information.
	 */
	public static void update() {
		CPU_LOAD_AVG = CPU.getSystemCpuLoad();
	}

}
