package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{

    @Override
    public void update(SystemMonitor monitor) {
        SystemState lastSystemState= monitor.getLastSystemState();

        if (lastSystemState.getAvailableMemory() < 200.00) {
            System.out.println("> Running garbage collector...");
        }
    }
}
