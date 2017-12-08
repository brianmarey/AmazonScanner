package com.careydevelopment.amazonscanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmazonScanner {
	
	private static final String[] URLS = {"https://www.amazon.com/s/ref=lp_196601011_nr_n_0?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A256565011&bbn=196601011&ie=UTF8&qid=1512744436&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_1?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A2522032011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_2?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A330390011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_3?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196603011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_4?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196604011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_5?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A255237011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_6?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A2522033011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_7?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A1243731011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_9?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196607011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_10?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196610011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_14?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A166048011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_11?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196612011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_12?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A166415011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_13?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A166273011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_14?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A166048011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_15?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A196608011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_16?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A389860011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_17?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A2522034011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_196601011_nr_n_18?fst=as%3Aoff&rh=n%3A165793011%2Cn%3A%21165795011%2Cn%3A196601011%2Cn%3A166861011&bbn=196601011&ie=UTF8&qid=1512744464&rnid=196601011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166737011&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_2?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166864011&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_3?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A322259011&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_4?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A16027271&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_7?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166739011&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166736011_nr_n_6?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A239221011&bbn=166736011&ie=UTF8&qid=1512744787&rnid=166736011",
		"https://www.amazon.com/s/ref=lp_166740011_nr_n_0?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166740011%2Cn%3A322263011&bbn=166740011&ie=UTF8&qid=1512744882&rnid=166740011",
		"https://www.amazon.com/s/ref=lp_166740011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166740011%2Cn%3A322264011&bbn=166740011&ie=UTF8&qid=1512744882&rnid=166740011",
		"https://www.amazon.com/s/ref=lp_166740011_nr_n_2?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166740011%2Cn%3A322265011&bbn=166740011&ie=UTF8&qid=1512744882&rnid=166740011",
		"https://www.amazon.com/s/ref=lp_166740011_nr_n_3?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166736011%2Cn%3A166740011%2Cn%3A322266011&bbn=166740011&ie=UTF8&qid=1512744882&rnid=166740011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_0?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A166838011&bbn=1272297011&ie=UTF8&qid=1512744967&rnid=1272297011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A173209011&bbn=1272297011&ie=UTF8&qid=1512744983&rnid=1272297011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_2?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A166837011&bbn=1272297011&ie=UTF8&qid=1512744983&rnid=1272297011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_3?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A166839011&bbn=1272297011&ie=UTF8&qid=1512744983&rnid=1272297011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_4?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A8457131011&bbn=1272297011&ie=UTF8&qid=1512744983&rnid=1272297011",
		"https://www.amazon.com/s/ref=lp_1272297011_nr_n_5?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166835011%2Cn%3A1272297011%2Cn%3A166849011&bbn=1272297011&ie=UTF8&qid=1512744983&rnid=1272297011",
		"https://www.amazon.com/b/ref=Baby_1214_CategoryTiles_PremiumStrollers_Standard/ref=s9_acss_bw_ct_refTest_ct6_a1_w?_encoding=UTF8&ie=UTF8&node=7696452011&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-4&pf_rd_r=8MNDRJEKA6BXEXF4EM12&pf_rd_t=101&pf_rd_p=5d0447d3-9e65-52b2-988d-8b52016748eb&pf_rd_i=166842011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct2_cta_w?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A!165797011%2Cn%3A8446318011%2Cn%3A166842011%2Cn%3A370094011&bbn=370094011&ie=UTF8&qid=1438365509&lo=baby-products&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-12&pf_rd_r=8MNDRJEKA6BXEXF4EM12&pf_rd_t=101&pf_rd_p=5d0447d3-9e65-52b2-988d-8b52016748eb&pf_rd_i=166842011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct5_cta_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A8446318011%2Cn%3A166842011%2Cn%3A166846011&ie=UTF8&lo=baby-products&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-12&pf_rd_r=8MNDRJEKA6BXEXF4EM12&pf_rd_t=101&pf_rd_p=5d0447d3-9e65-52b2-988d-8b52016748eb&pf_rd_i=166842011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct4_cta_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A8446318011%2Cn%3A166842011%2Cn%3A166845011&bbn=166845011&ie=UTF8&lo=baby-products&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-12&pf_rd_r=8MNDRJEKA6BXEXF4EM12&pf_rd_t=101&pf_rd_p=5d0447d3-9e65-52b2-988d-8b52016748eb&pf_rd_i=166842011",
		"https://www.amazon.com/s/ref=lp_166765011_nr_n_0?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166764011%2Cn%3A166765011%2Cn%3A6104938011&bbn=166765011&ie=UTF8&qid=1512745207&rnid=166765011",
		"https://www.amazon.com/s/ref=lp_166765011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166764011%2Cn%3A166765011%2Cn%3A6104939011&bbn=166765011&ie=UTF8&qid=1512745207&rnid=166765011",
		"https://www.amazon.com/s/ref=lp_166764011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166764011%2Cn%3A166811011&bbn=166764011&ie=UTF8&qid=1512745199&rnid=166764011",
		"https://www.amazon.com/s/ref=lp_166764011_nr_n_4?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166764011%2Cn%3A166767011&bbn=166764011&ie=UTF8&qid=1512745199&rnid=166764011",
		"https://www.amazon.com/s/ref=lp_166764011_nr_n_6?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166764011%2Cn%3A322263011&bbn=166764011&ie=UTF8&qid=1512745199&rnid=166764011",
		"https://www.amazon.com/s/ref=lp_166784011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166777011%2Cn%3A166784011%2Cn%3A166786011&bbn=166784011&ie=UTF8&qid=1512745316&rnid=166784011",
		"https://www.amazon.com/b/ref=cato_feeding_highchairs/ref=s9_acss_bw_ct_refTest_ct3_a2_w?_encoding=UTF8&ie=UTF8&node=166796011&pf_rd_m=ATVPDKIKX0DER&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-4&pf_rd_s=merchandised-search-4&pf_rd_r=5TR3BDVX3Y5DRKNS0VQN&pf_rd_r=1RDR8VDBXSY5V8RVAT7E&pf_rd_t=101&pf_rd_t=101&pf_rd_p=1bdc3694-0ec4-5698-b1ad-05e8d3a7589d&pf_rd_p=1865895602&pf_rd_i=166777011&pf_rd_i=166777011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct6_a1_w?rh=i%3Ababy-products%2Cn%3A166801011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=5TR3BDVX3Y5DRKNS0VQN&pf_rd_t=101&pf_rd_p=1bdc3694-0ec4-5698-b1ad-05e8d3a7589d&pf_rd_i=166777011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct7_a1_w?rh=i%3Ababy-products%2Cn%3A166795011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=5TR3BDVX3Y5DRKNS0VQN&pf_rd_t=101&pf_rd_p=1bdc3694-0ec4-5698-b1ad-05e8d3a7589d&pf_rd_i=166777011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct1_cta_w?rh=i%3Ababy-products%2Cn%3A166829011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct2_a1_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A166828011%2Cn%3A166841011%2Cp_n_feature_keywords_browse-bin%3A5590737011&bbn=166841011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct2_a4_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A166828011%2Cn%3A2237484011&bbn=166828011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct3_a1_w?rh=i%3Ababy-products%2Cn%3A166853011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct3_a2_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A166828011%2Cn%3A166850011%2Cn%3A166851011&bbn=166850011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct3_a3_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A166828011%2Cn%3A166850011%2Cn%3A166852011&bbn=166850011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct3_a4_w?rh=i%3Ababy-products%2Cn%3A322268011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct4_a1_w?rh=i%3Ababy-products%2Cn%3A196609011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=s9_acss_bw_ct_refTest_ct4_a2_w?rh=i%3Ababy-products%2Cn%3A165796011%2Cn%3A!165797011%2Cn%3A166828011%2Cn%3A239225011&bbn=166828011&ie=UTF8&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-11&pf_rd_r=8HBXW90Y7T66E4GV1SD5&pf_rd_t=101&pf_rd_p=96ebec69-2aac-5e88-afde-8083b83b4dc1&pf_rd_i=166828011",
		"https://www.amazon.com/s/ref=lp_166887011_nr_n_1?fst=as%3Aoff&rh=n%3A165796011%2Cn%3A%21165797011%2Cn%3A166887011%2Cn%3A166889011&bbn=166887011&ie=UTF8&qid=1512745669&rnid=166887011",
		"https://www.amazon.com/b/ref=s9_acsd_hfnv_hd_bw_bBIEvz_ct_x_ct03_w?_encoding=UTF8&node=166888011&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-4&pf_rd_r=PP8JP0HW78ZBGF727248&pf_rd_t=101&pf_rd_p=073ce383-a477-535f-816e-ad55994fee19&pf_rd_i=166887011",
		"https://www.amazon.com/b/ref=sr_aj?node=898402&ajr=0",
		"https://www.amazon.com/b/ref=sr_aj?node=166870011&ajr=0"
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
			categoriesBuilder.append("\",\"\"},\n");
			//System.err.println(word);
		} else {
			categoriesBuilder.append("{\"\",\"\"},\n");
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
			} else {
				nodesBuilder.append("\"\",");
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
		} else {
			brandsBuilder.append("\"\",\n");
		}
	}
}
