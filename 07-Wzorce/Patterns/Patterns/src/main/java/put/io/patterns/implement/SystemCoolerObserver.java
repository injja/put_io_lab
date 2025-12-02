package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver{
    @Override
    public void update(SystemMonitor monitor) {
        SystemState lastSystemState = monitor.getLastSystemState();
        if (lastSystemState.getCpuTemp() > 60.00) {
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
