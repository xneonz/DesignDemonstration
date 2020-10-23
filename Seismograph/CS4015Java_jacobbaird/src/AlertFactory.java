public class AlertFactory extends AbstractAlertFactory {
	public AbstractEarthquakeAlert createEarthquakeAlert() {
		return new EarthquakeAlert();
	}
	public AbstractTsunamiAlert createTsunamiAlert() {
		return new TsunamiAlert();
	}
}