package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.RecordDao;
import poly.model.Record;
import poly.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {
@Autowired
RecordDao recordDao;
	
	@Override
	public List<Record> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findAllIndex(int page, String idStaff) {
		int maxResult = 9;
		int firstResult = (page -1)*9;	
		return recordDao.findAllIndex(firstResult, maxResult, idStaff);
	}

	@Override
	public List<Record> findByStaffId(String staffid) {
	
		return recordDao.findByStaffId(staffid);
	}

	@Override
	public Record findById(int id) {
	
		return recordDao.findById(id);
	}
	
	@Override
	public boolean deleteRecord(Record record) {
	
		return recordDao.deleteRecord(record);
	}

	@Override
	public boolean insertRecord(Record record) {
		
		return recordDao.insertRecord(record);
	}

	@Override
	public boolean updateRecord(Record record) {
		
		return recordDao.updateRecord(record);
	}

	


}
