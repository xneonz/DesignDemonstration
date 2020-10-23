public class WarningFactory extends AbstractAlertFactory {
	public AbstractEarthquakeAlert createEarthquakeAlert() {
		return new EarthquakeWarning();
	}
	public AbstractTsunamiAlert createTsunamiAlert() {
		return new TsunamiWarning();
	}
}