package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    int lastCount=-999;
    @Override
    public void update(SystemMonitor monitor) {
        SystemState state = monitor.getLastSystemState();
        int current= state.getUsbDevices();

        if (lastCount == -999) {
            lastCount = current;
            return;
        }
        if (current != lastCount) {
            if (current > lastCount) {
                System.out.println("USB connected");
            } else {
                System.out.println("USB disconnected");
            }
            lastCount = current;
        }
    }
}
