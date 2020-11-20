package test;

public class StatLib
{
	// simple average
	public static float avg(float[] x)
	{
		float sum=0;
		for(int i=0;i<x.length;i++) {
			sum+=x[i];
		}
		return sum/x.length;
			
	}

	
	// returns the variance of X and Y
	public static float var(float[] x){
	        float mean1 = avg(x); 
	      
	        // Compute sum squared  
	        // differences with mean. 
	        float sqDiff = 0; 
	        for (int i = 0; i < x.length; i++)  
	            sqDiff += (x[i] - mean1) *  (x[i] - mean1); 
	          
	        return (float)sqDiff / x.length; 
	}

	//returns the mean of arr
	public static float mean(float arr[], int n) 
	{ 
	    float sum = 0; 
	    for(int i = 0; i < n; i++) 
	        sum = sum + arr[i]; 
	    return sum / n; 
	} 
	
	
	// returns the covariance of X and Y
	public static float cov(float[] x, float[] y){

	    float sum = 0; 
	    int n=x.length;
	    for(int i = 0; i < n; i++) 
	        sum = sum + (x[i] - mean(x, n)) *  (y[i] - mean(y, n)); 
	    return sum / (n);
	}


	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y){
		float covariance= cov(x,y);
		float stdDev1 = (float) Math.sqrt(var(x));
		float stdDev2 = (float) Math.sqrt(var(y));
		return covariance/(stdDev1*stdDev2);
	}

	// performs a linear regression and returns the line equation
	public static Line linear_reg(Point[] points){
		float [] arrX = new float [points.length];
		float [] arrY = new float [points.length];
		float a,b,covariance,variance,aveX,aveY;
		for(int i=0;i<points.length;i++) {
			arrX[i]=points[i].x;
			arrY[i]=points[i].y;		
		}
		covariance=cov(arrX,arrY);
		variance= var(arrX);
		a=covariance/variance;
		aveX=avg(arrX);
		aveY=avg(arrY);
		b=aveY-(a*aveX);
		Line l= new Line(a,b);
		return l;			
	}

	// returns the deviation between point p and the line equation of the points
	public static float dev(Point p,Point[] points){
		Line l=linear_reg(points);
	   float d=((l.a*p.x)-p.y+l.b);
	   return d;	
	}

	// returns the deviation between point p and the line
	public static float dev(Point p,Line l){
	   float d=((l.a*p.x)-p.y+l.b);
	   return d;
	}
	
}
