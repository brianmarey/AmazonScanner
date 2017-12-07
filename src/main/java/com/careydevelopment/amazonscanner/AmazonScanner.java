package com.careydevelopment.amazonscanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmazonScanner {
	
	private static final String[] URLS = {"https://www.amazon.com/s/ref=lp_6127770011_ex_n_5?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679286011&bbn=6127770011&ie=UTF8&qid=1512672672",
		"https://www.amazon.com/s/ref=lp_679286011_ex_n_10?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679271011&bbn=6127770011&ie=UTF8&qid=1512673135",
		"https://www.amazon.com/s/ref=lp_679271011_ex_n_8?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679278011&bbn=6127770011&ie=UTF8&qid=1512675751",
		"https://www.amazon.com/s/ref=lp_679271011_ex_n_9?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A3420963011&bbn=6127770011&ie=UTF8&qid=1512675751",
		"https://www.amazon.com/s/ref=lp_679271011_ex_n_9?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A3420963011&bbn=6127770011&ie=UTF8&qid=1512675751",
		"https://www.amazon.com/s/ref=lp_679272011_ex_n_11?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679303011&bbn=6127770011&ie=UTF8&qid=1512675911",
		"https://www.amazon.com/s/ref=lp_679272011_ex_n_11?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679303011&bbn=6127770011&ie=UTF8&qid=1512675911",
		"https://www.amazon.com/s/ref=lp_679295011_ex_n_14?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679304011&bbn=6127770011&ie=UTF8&qid=1512675941",
		"https://www.amazon.com/s/ref=lp_679304011_ex_n_15?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679305011&bbn=6127770011&ie=UTF8&qid=1512675952",
		"https://www.amazon.com/s/ref=lp_679305011_ex_n_16?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679268011&bbn=6127770011&ie=UTF8&qid=1512675965",
		"https://www.amazon.com/s/ref=lp_679268011_ex_n_17?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A6127770011%2Cn%3A679273011&bbn=6127770011&ie=UTF8&qid=1512675978",
		"https://www.amazon.com/s/ref=lp_679273011_ex_n_19?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A679312011&bbn=679255011&ie=UTF8&qid=1512675989",
		"https://www.amazon.com/s/ref=lp_679312011_ex_n_7?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A679313011&bbn=679255011&ie=UTF8&qid=1512676005",
		"https://www.amazon.com/s/ref=lp_679313011_ex_n_8?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A3420996011&bbn=679255011&ie=UTF8&qid=1512676021",
		"https://www.amazon.com/s/ref=lp_6127766011_ex_n_19?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A679319011&bbn=679255011&ie=UTF8&qid=1512676057",
		"https://www.amazon.com/s/ref=lp_679319011_ex_n_13?rh=n%3A7141123011%2Cn%3A7147441011%2Cn%3A679255011%2Cn%3A679334011&bbn=679255011&ie=UTF8&qid=1512676075",
		"https://www.amazon.com/s/ref=lp_6127771011_ex_n_5?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679360011&bbn=6127771011&ie=UTF8&qid=1512676121",
		"https://www.amazon.com/s/ref=lp_679360011_ex_n_10?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679351011&bbn=6127771011&ie=UTF8&qid=1512676127",
		"https://www.amazon.com/s/ref=lp_679351011_ex_n_8?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679353011&bbn=6127771011&ie=UTF8&qid=1512676138",
		"https://www.amazon.com/s/ref=lp_679353011_ex_n_9?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A3412245011&bbn=6127771011&ie=UTF8&qid=1512676152",
		"https://www.amazon.com/s/ref=lp_3412245011_ex_n_10?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679352011&bbn=6127771011&ie=UTF8&qid=1512676163",
		"https://www.amazon.com/s/ref=lp_679352011_ex_n_11?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679377011&bbn=6127771011&ie=UTF8&qid=1512676177",
		"https://www.amazon.com/s/ref=lp_679377011_ex_n_12?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679339011&bbn=6127771011&ie=UTF8&qid=1512676189",
		"https://www.amazon.com/s/ref=lp_679339011_ex_n_13?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679369011&bbn=6127771011&ie=UTF8&qid=1512676201",
		"https://www.amazon.com/s/ref=lp_679369011_ex_n_15?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679378011&bbn=6127771011&ie=UTF8&qid=1512676219",
		"https://www.amazon.com/s/ref=lp_679378011_ex_n_16?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A6127771011%2Cn%3A679348011&bbn=6127771011&ie=UTF8&qid=1512676233",
		"https://www.amazon.com/s/ref=lp_679348011_ex_n_18?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679394011&bbn=679337011&ie=UTF8&qid=1512676244",
		"https://www.amazon.com/s/ref=lp_679394011_ex_n_7?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679399011&bbn=679337011&ie=UTF8&qid=1512676256",
		"https://www.amazon.com/s/ref=lp_679399011_ex_n_8?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679404011&bbn=679337011&ie=UTF8&qid=1512676268",
		"https://www.amazon.com/s/ref=lp_679404011_ex_n_9?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679410011&bbn=679337011&ie=UTF8&qid=1512676280",
		"https://www.amazon.com/s/ref=lp_679410011_ex_n_11?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679415011&bbn=679337011&ie=UTF8&qid=1512676293",
		"https://www.amazon.com/s/ref=lp_679415011_ex_n_12?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679416011&bbn=679337011&ie=UTF8&qid=1512676304",
		"https://www.amazon.com/s/ref=lp_679425011_ex_n_14?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A10509644011&bbn=679425011&ie=UTF8&qid=1512676327",
		"https://www.amazon.com/s/ref=lp_10509644011_ex_n_15?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A10509645011&bbn=679425011&ie=UTF8&qid=1512676336",
		"https://www.amazon.com/s/ref=lp_10509645011_ex_n_16?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A10509650011&bbn=679425011&ie=UTF8&qid=1512676348",
		"https://www.amazon.com/s/ref=lp_10509650011_ex_n_17?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A679365011&bbn=679425011&ie=UTF8&qid=1512676361",
		"https://www.amazon.com/s/ref=lp_679365011_ex_n_18?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A10509646011&bbn=679425011&ie=UTF8&qid=1512676373",
		"https://www.amazon.com/s/ref=lp_10509646011_ex_n_19?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679425011%2Cn%3A10509649011&bbn=679425011&ie=UTF8&qid=1512676385",
		"https://www.amazon.com/s/ref=lp_10509649011_ex_n_20?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679433011&bbn=679337011&ie=UTF8&qid=1512676397",
		"https://www.amazon.com/s/ref=lp_679433011_ex_n_15?rh=n%3A7141123011%2Cn%3A7147440011%2Cn%3A679337011%2Cn%3A679442011&bbn=679337011&ie=UTF8&qid=1512676410"
	};
	
	private StringBuilder categoriesBuilder = new StringBuilder();
	private StringBuilder nodesBuilder = new StringBuilder();
	private StringBuilder brandsBuilder = new StringBuilder();
	
	public static void main(String[] args) {
		AmazonScanner asc = new AmazonScanner();
		asc.go();
	}

	
	private void go() {
		categoriesBuilder.append("{");
		nodesBuilder.append("{");
		brandsBuilder.append("{");
		
		for (int i=0;i<URLS.length;i++) {
			String url = URLS[i];
			
			InputStream is = null;
			HttpURLConnection httpcon = null;
			BufferedReader reader = null;
			
			try {
				URL urlConn = new URL(url);
				httpcon = (HttpURLConnection) urlConn.openConnection();
			    httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
			    
			    is = httpcon.getInputStream();
			   
			    reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));

			    StringBuilder sb = new StringBuilder();
			    String inputLine;
			    while ((inputLine = reader.readLine()) != null) {
			    	//System.err.println(inputLine);
			    	sb.append(inputLine);
			    }
			    				            
			    String contents = sb.toString();
			    
			    getCategory(contents);
			    getNode(contents);
			    getBrand(contents);
			    //System.err.println(contents);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null) reader.close();
					if (is != null) is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		categoriesBuilder.append("}");
		nodesBuilder.append("}");
		brandsBuilder.append("}");
		
		System.err.println(categoriesBuilder.toString());
		System.err.println("\n\n\n");
		System.err.println(nodesBuilder.toString());
		System.err.println("\n\n\n");
		System.err.println(brandsBuilder.toString());
	}
	
	
	private void getCategory(String contents) {
		String searchTerm = "<span class=\"nav-search-label\">";
		
		if (contents.indexOf(searchTerm) > -1) {
			int start = contents.indexOf(searchTerm) + searchTerm.length();
			int end = contents.indexOf("<", start + 1);
			String word = contents.substring(start,end);
			categoriesBuilder.append("{\"");
			categoriesBuilder.append(word);
			categoriesBuilder.append("\",\"\"},");
			//System.err.println(word);
		}
	}
	
	
	private void getNode(String contents) {
		String searchTerm = "<link rel=\"canonical\"";
		String searchTerm2 = "node=";
		
		if (contents.indexOf(searchTerm) > -1) {
			int start = contents.indexOf(searchTerm) + searchTerm.length();
			int nodeStart = contents.indexOf(searchTerm2, start + 1);
			
			if (nodeStart > -1) {
				int end = contents.indexOf("\"", nodeStart);
				String word = contents.substring(nodeStart + searchTerm2.length(),end);
				nodesBuilder.append("\"");
				nodesBuilder.append(word);
				nodesBuilder.append("\",");
				//System.err.println(word);	
			}			
		}
	}
	 
	
	private void getBrand(String contents) {
		String searchTerm = "lbr_brands";
		
		if (contents.indexOf(searchTerm) > -1) {
			int start = contents.lastIndexOf("\"", contents.indexOf(searchTerm));
			int end = contents.indexOf("\"", start + 1);
			String word = contents.substring(start + 1,end);
			word = word.replaceAll("&amp;", "&");
			brandsBuilder.append("\"https://www.amazon.com");
			brandsBuilder.append(word);
			brandsBuilder.append("\",\n");
			//System.err.println(word);
		}
	}
}
