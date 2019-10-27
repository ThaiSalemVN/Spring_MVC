package poly.dao;

import java.util.List;

import poly.model.Record;



public interface RecordDao {
	List<Record>  findAll();
	
	List<Record> findAllIndex(int firstResult, int maxResult, String idStaff);
	
	List<Record> findByStaffId(String staffid);
	
	Record findById(int id);
	
	boolean deleteRecord(Record record);
	
	boolean insertRecord(Record record);
	
	boolean updateRecord(Record record);
}
