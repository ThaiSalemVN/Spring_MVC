package poly.service;

import java.util.List;

import poly.model.Record;

public interface RecordService {
    List<Record>  findAll();
	
	List<Record> findAllIndex(int page, String idStaff);
	
	List<Record> findByStaffId(String staffid);
	
	Record findById(int id);
	 
	boolean deleteRecord(Record record);
	
	boolean insertRecord(Record record);
	
	boolean updateRecord(Record record);
}
