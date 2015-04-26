package hello;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MockDB extends DBTestCase {

	private IDataSet dataSet;

	public MockDB(String name) {
		super(name);

		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
				"com.mysql.jdbc.Driver");
		System.setProperty(
				PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
				"jdbc:mysql://localhost/xebiastoretest");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
				"root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
				"root");
		// System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA,
		// "xebiastore" );

	}

	protected IDataSet getDataSet() throws Exception {

		return new FlatXmlDataSetBuilder().build(this.getClass()
				.getClassLoader().getResourceAsStream("dataset.xml"));

	}

	@Before
	public void setup() {
		try {
			dataSet = getDataSet();
		}

		catch (Exception ex) {

		}

	}

	@Test
	public void testTrue() {
		int rowCount = 0;
		try {
			rowCount = (dataSet.getTable("user")).getRowCount();
		} catch (Exception ex) {

		}

		assertEquals(true, rowCount > 0);
	}

}
