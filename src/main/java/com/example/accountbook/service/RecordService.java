package com.example.accountbook.service;

import com.example.accountbook.entity.Record;
import com.example.accountbook.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    public void addRecord(Record record) {
        recordMapper.insert(record);
    }

    public void deleteRecord(Integer id) {
        recordMapper.deleteById(id);
    }

    public void updateRecord(Record record) {
        recordMapper.update(record);
    }

    public Record getRecordById(Integer id) {
        return recordMapper.selectById(id);
    }

    public List<Record> getRecordsByMonth(String month) {
        return recordMapper.selectByMonth(month);
    }

    public Map<String, BigDecimal> getMonthTotal(String month) {
        return recordMapper.selectMonthTotal(month);
    }

    public List<Map<String, Object>> getCategoryStats(String month) {
        return recordMapper.selectCategoryStats(month);
    }
}