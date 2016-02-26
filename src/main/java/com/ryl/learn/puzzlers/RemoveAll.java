package com.ryl.learn.puzzlers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RemoveAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		for(int i=0;i<10;i++){
			list.add(new Long(i));
		}
		List<Long> subList = new ArrayList<Long>();
		for(int i=0;i<5;i++){
			subList.add(new Long(i));
		}
		System.out.println(list.removeAll(subList));
		System.out.println(list);
		Long millis = System.currentTimeMillis();
		System.out.println(millis.toString());
		System.out.println("MIICXjCCAjUTE1BBWUxPQURfU0VTU0lPTkRBVEExggIcMIIByxMNRU5DUllQVFRJQ0tFVASCAbhXc%2FyCrzk96Qa0QfPXwvCdh4tVVVPVJapioF5qj0w3uM5xxTRLtSu8dd%2BFy5BXVVSY49uXsz0EyK%2BUdN6Jo6YRLG%2Fzz%2BBgnXworbwdNegUM35CA%2BnJy0ZoBMs%2BhAMOeR7wlsscWnI5BtWSh3ttJSmEQfPqDZv7VRLwr%2BmsbRsxhXi8RUOYYBawN2qhVE9%2FTYkX2vyHfTlb9pRm7odh2GUo0xioVp%2FcOTrdOLdWzQ7HXNQ7v3nORWaqeYFXcB8KQRtQnDDmBI0PIPkc6D6zTEM9qz4e%2Ba%2FcWJ7FPMrzEHl5nngR5hOb%2BduDJ0cPzjLA3fMRIIWNAvI6z7Ipxpwzs0gmfr%2BSilrlAI3104QRdc7vPu4cwxWfb11zLNzsJhrDdNrZ%2BLipxB%2Bqhf9RDpIcJ7NXOnRgVaQMuL6JLde%2FbA1fSfMYuoo%2FZMi2CN8HXAoN92lKbSdWTg4q3Z21Lu2aKAJqWEFFEBpW7ggLqSwshiqwFuKHlEm3EfQ9u5vmGd8V4%2BMCLNJAPV%2FaoEQNTapbjik2k2pF6%2Fsx4esBr7vuMIwBFiUiUEVio4SLdhF2fMcaxuKY02SD%2FqAn3TAMEwVLRVlJRAQDMTA3MD0TCVNFU1NJT05JRAQwNzYyRjhBOTczQUIxNzU1MzE1QkYxQjNDOEE0RjA0NjdGQTVBQjAwMTJEMTI5REI4MAwGCCsGAQUFCAECBQADFQDvB2G%2F1zgclZ64WK5urrfIGgeifg%3D%3D".length());
	}

}
