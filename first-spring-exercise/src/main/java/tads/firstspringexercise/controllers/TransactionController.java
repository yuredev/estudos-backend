package tads.firstspringexercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.firstspringexercise.models.Transaction;
import tads.firstspringexercise.services.TransactionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService ts) {
        this.transactionService = ts;
    }

    @RequestMapping("/")
//    recebe tambem o HttpServletRequest e HttpServletResponse
    public String getHome(Model model /*, HttpServletRequest request,  HttpServletResponse response */) {
        List<Transaction> transactionList = transactionService.findAll();
        model.addAttribute("transactionList", transactionList);
        return "index";
    }
}
