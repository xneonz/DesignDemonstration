import java.util.List;
import javax.swing.JList;

public abstract class SeismometerListViewTarget {
	
	public abstract void setItems(List<String> items);
	public abstract JList<String> getListView();
}