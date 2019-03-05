package com.undefined24.ssm.util;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Line {
	public static final String APPKEY = "ad138926a76c8961";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/train/line";
 
    public static ArrayList<String> Get(String MyTrainno) {
        String result = null;
        String url = URL + "?appkey=" + APPKEY + "&trainno=" + MyTrainno;
        ArrayList<String> myCities = new ArrayList<String>();
 
        try {
            result = HttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.optJSONObject("result");
                String trainno = resultarr.getString("trainno");
                String type = resultarr.getString("type");
                System.out.println(trainno + " " + type);
                if (resultarr.opt("list") != null) {
                    JSONArray list = resultarr.optJSONArray("list");
                    for (int i = 0; i < list.size(); i++) {
                        JSONObject obj = (JSONObject) list.opt(i);
                        String sequenceno = obj.getString("sequenceno");
                        String station = obj.getString("station");
                        myCities.add(station);
                        /*String day = obj.getString("day");
                        String arrivaltime = obj.getString("arrivaltime");
                        String departuretime = obj.getString("departuretime");
                        String stoptime = obj.getString("stoptime");
                        String costtime = obj.getString("costtime");
                        String distance = obj.getString("distance");
                        String isend = obj.getString("isend");
                        String pricesw = obj.getString("pricesw");
                        String pricetd = obj.getString("pricetd");
                        String pricegr1 = obj.getString("pricegr1");
                        String pricegr2 = obj.getString("pricegr2");
                        String pricerw1 = obj.getString("pricerw1");
                        String pricerw2 = obj.getString("pricerw2");
                        String priceyw1 = obj.getString("priceyw1");
                        String priceyw2 = obj.getString("priceyw2");
                        String priceyw3 = obj.getString("priceyw3");
                        String priceyd = obj.getString("priceyd");
                        String priceed = obj.getString("priceed");
                        String pricerz = "";*/
                        /*if (obj.has("pricerz")) {
                            pricerz = obj.getString("pricerz");
                        }
                        String priceyz = "";
                        if (obj.has("priceyz")) {
                            priceyz = obj.getString("priceyz");
                        }*/
                        /*System.out.println(sequenceno + " " + station + " " + day + " " + arrivaltime + " "
                                + departuretime + " " + stoptime + " " + costtime + " " + distance + " " + isend + " "
                                + pricesw + " " + pricetd + " " + pricegr1 + " " + pricegr2 + " " + pricerw1 + " "
                                + pricerw2 + " " + priceyw1 + " " + priceyw2 + " " + priceyw3 + " " + priceyd + " "
                                + priceed + " " + pricerz + " " + priceyz);*/
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(String s : myCities){
    		System.out.println(s);
    	}
        return myCities;
    }
}
