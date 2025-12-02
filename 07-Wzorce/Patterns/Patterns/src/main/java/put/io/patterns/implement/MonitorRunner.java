package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){

        SystemMonitor monitor = new SystemMonitor();

        SystemStateObserver infObserver =  new SystemInfoObserver();
        monitor.addSystemStateObserver(new SystemInfoObserver());
        monitor.addSystemStateObserver(new SystemGarbageCollectorObserver());
        monitor.addSystemStateObserver(new SystemCoolerObserver());
        monitor.addSystemStateObserver(new USBDeviceObserver());

        while (true) {
            monitor.probe();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
