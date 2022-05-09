package com.board.util;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.board.constant.Method;

@Controller
public class UiUtils {

	public String showMessageWithRedirect(
        String message, String redirectUri, Method method,
        Map<String, Object> params, Model model) {

		model.addAttribute("message", message);
		model.addAttribute("redirectUri", redirectUri);
		model.addAttribute("method", method);
		model.addAttribute("params", params);

		return "utils/message-redirect";
	}

}