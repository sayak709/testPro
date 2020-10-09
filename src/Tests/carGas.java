package Tests;

public class carGas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int canCompleteCircuit (int[] gas, int[] cost) {
		int n = gas.length;
        if (n==1){
            if (gas[0]>=cost[0]){
            return 0;
            } 
            else {
                return -1;
            }
        }
		int s = indFind(gas, cost, 0);
		if (s==-1) {
			return -1;
		}
		return canCompleteCircuitM(gas, cost, n, s, n, s);
	}
	public static int canCompleteCircuitM(int[] gas, int[] cost, int f, int s, int l, int a) { // f counts whether looped in once or not, s is starting position, l to terminate
        int n = gas.length;
		int t = gas[s];
        int p = s;
        int x = f;
        int y = l-a;
        while(t >= cost[p]) {
        	t -= cost[p];
        	if ( p == n-1) {
        		p = 0;
        	}
        	else {
        		p++;
        	}
        	t += gas[p]; 
        	x--;
        	if(x==0) {
        		return s;
        	}
        }
        if (p>s) {
        	y -= p - s;
        }
        else {
        	y -= n - s + p;
        }
        if (y < 0 || (y==0 && gas[n-1]<cost[n-1])) {
        
    		return -1;
    	}

        
        int h = indFind(gas, cost, p);
        if (h == -1) {
        	return -1;
        } 
        int b = 0;
        if (h > p) {
        b = (h-p);
        }
        else {
        	b = n - p + h;
        }

        return canCompleteCircuitM(gas, cost, f, h, y, b);
	}  
	public static int indFind  (int[] gas, int[] cost, int start)  {
        int n = gas.length;
    	int s = start;
        while (gas[s] < cost[s]) {
        	if(s == n - 1 && gas[s] < cost[s]) {
        		return -1;
        	}
        	s++;
        }
        return s;
    }


}
