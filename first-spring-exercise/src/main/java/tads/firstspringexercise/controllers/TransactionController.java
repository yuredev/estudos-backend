package tads.firstspringexercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tads.firstspringexercise.models.Transaction;
import tads.firstspringexercise.services.TransactionService;

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

    @RequestMapping("/create")
    public String getCreateTransactionPage(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String add(@ModelAttribute Transaction transaction) {
        transactionService.add(transaction);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id) {
        Transaction transaction = transactionService.getOne(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("transaction", transaction);
        return modelAndView;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        transactionService.delete(id);
        return "redirect:/";
    }
}
