package recordwriter.resouce;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recordwriter.Repository.RecordRepository;
import recordwriter.model.Record;

import java.util.List;

/**
 * Created by kajiwarayutaka on 2015/06/02.
 */
@RestController
@RequestMapping("/api")
public class RecordResource {
    @Autowired
    RecordRepository recordRepository;

    @RequestMapping(value="records",method= RequestMethod.GET)
    public List<Record> getRecords(){
        return recordRepository.findAll();
    }

    @RequestMapping(value="record/{id}",method = RequestMethod.GET)
    public Record getRecord(@PathVariable(value = "id") Integer id){
        return recordRepository.findOne(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="record/{id}",method = RequestMethod.DELETE)
    public void deleteRecord(@PathVariable(value = "id") Integer id){
        recordRepository.delete(id);
    }
}
