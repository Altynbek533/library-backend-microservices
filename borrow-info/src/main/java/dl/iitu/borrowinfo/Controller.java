package dl.iitu.borrowinfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class Controller {


    @Autowired
    Repository repository;

    @GetMapping("/all")
    public List<Borrow> allBook(){
        return repository.findAll();
    }

    @PostMapping("/addborrow")
    public Borrow createBook(@Valid @RequestBody Borrow borrow) {
        return repository.save(borrow);
    }

    @GetMapping("/borrow/{userId}")
    public Borrow getAllBorrowBookByUserID(@PathVariable("userId") Integer userId) throws ResourceNotFoundException {
        Borrow borrow = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));
        return borrow;
    }

    @DeleteMapping("/borrow/{id}")
    public Map<String, Boolean> deleteBorrow(@PathVariable(value = "id") Integer borrowId)
            throws ResourceNotFoundException {
        Borrow borrow = repository.findById(borrowId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + borrowId));

        repository.delete(borrow);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


//    List<Borrow> list = Arrays.asList(
//                new Borrow(1,1,1,"17-10-2019", "25-05-2020"),
//                new Borrow(2,2,1,"11-10-2019", "25-05-2020"),
//                new Borrow(3,3,1,"21-10-2019", "25-05-2020"),
//                new Borrow(4,1,2,"11-10-2019", "25-05-2020"),
//                new Borrow(5,3,2,"11-10-2019", "25-05-2020")
//        );
//
//        for (Borrow borrowList : list){
//            if (borrowList.getUserID().equals(userId)){
//                return borrowList;
//            }
//        }
//        return null;
