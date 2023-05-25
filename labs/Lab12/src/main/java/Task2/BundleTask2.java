package Task2;

import java.util.ListResourceBundle;

public class BundleTask2 extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		return content;
	}
	static final Object[][]content={
			{"count.one","First Test"},
			{"count.second","Second Test"},
			{"count.third","Third Test"}
	};
}
