import java.util.List;
import javax.swing.JList;

public class SeismometerListViewAdapter extends SeismometerListViewTarget {
	
	public SeismometerListViewAdapter() {
		
		listView = new JList<String>();
		
	}
	
	private JList<String> listView;
	
	public void setItems(List<String> items) {
		
		String[] array = new String[items.size()];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = items.get(i);
			
		}
		
		listView.setListData(array);
		
	}
	
	public JList<String> getListView() {
		
		return listView;
		
	}
}