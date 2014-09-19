package dat.service;

import java.sql.SQLException;

import db.connect.MyExecuteData;
import db.connect.MyGetData;
import db.define.DBConfig;
import db.define.MyTableModel;

public class WapRegLog
{
	public MyExecuteData mExec;
	public MyGetData mGet;
	
	public WapRegLog(DBConfig mConfigObj) throws Exception
	{
		try
		{
			mExec = new MyExecuteData(mConfigObj);
			mGet = new MyGetData(mConfigObj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param Type
	 * <p>Type = 2: Lấy chi tiết 1 Record mới nhất (Para_1 = MSISDN)
	 * @param Para_1
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type, String Para_1) throws Exception, SQLException
	{
		try
		{
			String Arr_Name[] ={"Type", "Para_1"};
			String Arr_Value[] ={Integer.toString(Type), Para_1};
			
			return mGet.GetData_Pro("Sp_WapRegLog_Select", Arr_Name, Arr_Value);
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public boolean Delete(int Type, String XMLContent) throws Exception
	{
		try
		{
			String[] Arr_Name = { "Type", "XMLContent" };
			String[] Arr_Value = { Integer.toString(Type), XMLContent };
			return mExec.Execute_Pro("Sp_Subscriber_Delete", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}
