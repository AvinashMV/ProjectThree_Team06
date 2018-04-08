package client.model;

import java.util.ArrayList;

import server.model.ServerModelSingleton;

public class ExpressivePlotData {
	
	private static volatile ExpressivePlotData expressivePlotData;
	private static Object mutex = new Object();
	private ArrayList<Float> raiseBrowList = new ArrayList<>();
	private ArrayList<Float> furrowBrowList = new ArrayList<>();
	private ArrayList<Float> smileList = new ArrayList<>();
	private ArrayList<Float> clenchList = new ArrayList<>();
	private ArrayList<Float> smirkLeftList = new ArrayList<>();
	private ArrayList<Float> smirkRightList = new ArrayList<>();
	private ArrayList<Float> laughList = new ArrayList<>();
	private ArrayList<Float> winkLeftList = new ArrayList<>();
	private ArrayList<Float> winkRightList = new ArrayList<>();
	private ArrayList<Float> lookLeftList = new ArrayList<>();
	private ArrayList<Float> lookRightList = new ArrayList<>();
	
	public static ExpressivePlotData getExpressivePlotData() {
		return expressivePlotData;
	}


	public ArrayList<Float> getRaiseBrowList() {
		return raiseBrowList;
	}

	public ArrayList<Float> getFurrowBrowList() {
		return furrowBrowList;
	}

	public ArrayList<Float> getSmileList() {
		return smileList;
	}

	public ArrayList<Float> getClenchList() {
		return clenchList;
	}

	public ArrayList<Float> getSmirkLeftList() {
		return smirkLeftList;
	}

	public ArrayList<Float> getSmirkRightList() {
		return smirkRightList;
	}

	public ArrayList<Float> getLaughList() {
		return laughList;
	}

	public ArrayList<Float> getWinkLeftList() {
		return winkLeftList;
	}

	public ArrayList<Float> getWinkRightList() {
		return winkRightList;
	}

	public ArrayList<Float> getLookLeftList() {
		return lookLeftList;
	}

	public ArrayList<Float> getLookRightList() {
		return lookRightList;
	}

	public ArrayList<Float> getBlinkList() {
		return blinkList;
	}


	private ArrayList<Float> blinkList = new ArrayList<>();
	private ArrayList<ArrayList<Float>> featuresList = new ArrayList<>();
	private boolean featureVal;
	
	
	
	public static ExpressivePlotData getInstance() {
		ExpressivePlotData result = expressivePlotData;
		if (result == null) {
			synchronized (mutex) {
				result = expressivePlotData;
				if (result == null)
					result = new ExpressivePlotData();
				expressivePlotData = result;
			}
		}
		return result;
	}
	
	public void setDataToList(ExpressiveData expressivedata) {
		
		raiseBrowList.add(expressivedata.getRaiseBrow());
		furrowBrowList.add(expressivedata.getFurrowBrow());
		smileList.add(expressivedata.getSmile());
		clenchList.add(expressivedata.getClench());
		smirkLeftList.add(expressivedata.getSmirkLeft());
		smirkRightList.add(expressivedata.getSmirkRight());
		laughList.add(expressivedata.getLaugh());
		
		this.featureVal = expressivedata.isBlink();
		blinkList.add(featureVal ? 1.0F : 0.0F);
		
		this.featureVal = expressivedata.isLookLeft();
		lookLeftList.add(featureVal ? 1.0F : 0.0F);
		
		this.featureVal = expressivedata.isLookRight();
		lookRightList.add(featureVal ? 1.0F : 0.0F);
		
		this.featureVal = expressivedata.isWinkLeft();
		winkLeftList.add(featureVal ? 1.0F : 0.0F);
		
		this.featureVal = expressivedata.isWinkRight();
		winkRightList.add(featureVal ? 1.0F : 0.0F);
		
		
	}
	
}
