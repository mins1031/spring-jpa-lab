package com.example.demo.account

//import com.example.demo.database.Database
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/account")
//class BalanceController(val db: Database) {
//    /**
//     *  TODO 비즈니스 로직을 작성해주세요
//     */
//
//
//    @GetMapping("{id}/balance")
//    fun balance(@PathVariable id: Long): Account {
//        return db.findAccount(accountId);
//    }
//
//    /**
//     *  TODO 비즈니스 로직을 작성해주세요
//     */
//    @PostMapping("{id}/deposit")
//    fun deposit(@PathVariable id: Long, @RequestBody amount: Long): Account {
//        return db.balance(id)
//    }
//
//    /**
//     *  TODO 비즈니스 로직을 작성해주세요
//     */
//    @PostMapping("{id}/withdraw")
//    fun withdraw(@PathVariable id: Long, @RequestBody amount: Long): Account {
//        return db.balance(id)
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = RunTimeException.class)
//    public RestResponse<Void> RunTimeExceptionHandler(RunTimeException e) {
//        log.info("서버에러 : {} ", e.getMessage() + Arrays.asList(e.getStackTrace()));
//        // 슬랙등 메신저로 alert
//        return RestResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//    }
//}