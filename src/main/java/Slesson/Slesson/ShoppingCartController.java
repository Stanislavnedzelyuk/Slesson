package Slesson.Slesson;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store/order")
public class ShoppingCartController {

    @PostMapping("/add")
    public void addToCart(@RequestBody List<Integer> itemIds, HttpSession session) {
        List<Integer> cart = getCartInSession(session);
        cart.addAll(itemIds);

    }


    @GetMapping("/get")
    public List<Integer> getCart(HttpSession session) {
        return getCartInSession(session);

    }


    @SuppressWarnings("unchecked")
    private List<Integer> getCartInSession(HttpSession session) {
        List<Integer> cart = (List<Integer>) session.getAttribute("CART_KEY");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("CART_KEY", cart);
        }

        return cart;
    }
}


