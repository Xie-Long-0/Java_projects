package backtrace;

public class Queen {
	int n;
	long sum;
    boolean[] shu, pie, na;     //棋盘上竖、撇、捺的状态标记
	long start, stop;
	
	public Queen(int _n)
	{
		n = _n;
		Init();
	}
	
	public void Init()
	{
        start = System.currentTimeMillis();
		sum = 0;
        shu = new boolean[n];
        pie = new boolean[2*n-1];
        na = new boolean[2*n-1];
		backtrace(0);
		sum *= 2;       //将前面对称算得的结果乘2
        if (n%2 == 1) {
            for (int i = 0; i <= n/2; i++) {
                clear(i, i);
            }           //如果是奇数，则将第一行的中间位设为已放置
            place(0, n/2);
            backtrace(1);   //从第二行开始摆棋
        }
	}
	
	void backtrace(int row)
	{
	    int cMax = (row == 0 ? n/2 : n);    //根据对称性只算一半
		for (int col = 0; col < cMax; col++) {
            if (!constraint(row, col)) {   //判断是否可以放置
                continue;
            }
            if (row >= n-1) {
                sum++;
                return;
            }
            place(row, col);    //设置已放置标记
            backtrace(row + 1);
            clear(row, col);    //清除标记
		}
	}
	
	boolean constraint(int row, int col)
	{
        int i = row + col;              //当前位置的撇编号
        int j = n - 1 + col - row;      //当前位置的捺编号
        if (shu[col] || pie[i] || na[j]) {
            return false;
        }
		return true;
	}

	void place(int row, int col)
    {
        int i = row + col;
        int j = n - 1 + col - row;
        shu[col] = pie[i] = na[j] = true;
    }

    void clear(int row, int col)
    {
        int i = row + col;
        int j = n - 1 + col - row;
        shu[col] = pie[i] = na[j] = false;
    }

    public void showResult()
	{
        stop = System.currentTimeMillis();
        long time = stop - start;
		System.out.println("time= "+time+"ms,\t"+"i= "+n+", Sum= "+sum);
	}
}
