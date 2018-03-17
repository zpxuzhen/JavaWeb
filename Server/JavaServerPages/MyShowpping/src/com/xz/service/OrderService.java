package com.xz.service;

import java.sql.*;
import java.util.*;
import com.xz.domain.*;
import com.xz.utils.*;

//�����붩����ص�ҵ���߼�
public class OrderService {
	// �������
	private Connection ct = null;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;
	private ResultSet rs = null;

	// �¶����漰�����ű�
	public boolean submitOrder(MyCart myCart, Users user) {
		boolean res=true;
		//������ﳵ�ǿյ�,ֱ�ӷ���false
		if(!myCart.NonEmpty()) return false;
		
		// ��Ϊ��Ӷ�������!�������ֲ������ر��������ǾͲ�ʹ��SQLHelper��������
		// ר������¶���д�����ݿ�Ĳ���
		try {
			ct = DBUtil.getCon();
			// ���óɲ��Զ��ύ
			ct.setAutoCommit(false);
			// Ϊ�˱�֤�ҵĶ��������ȶ��ģ����Խ���������뼶������(�ɴ��л�)
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			// ���orders��
			String sql = "insert into orders values(orders_seq.nextval,?,?,sysdate)";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ps.setFloat(2, myCart.getTotalPrice());
			ps.executeUpdate();

			// ��ѯorder_id��
			sql = "select orders_seq.currval from orders";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			int order_id = 0;
			if (rs.next()) {
				// ȡ���ո����ɵĶ�����
				order_id = rs.getInt(1);
			}

			// ���ordersItem��
			sql = "insert into ordersItem values(ordersItem_seq.nextval,?,?,?)";
			ArrayList<Books> books = myCart.showMyCart();
			for (Books book : books) {
				ps = ct.prepareStatement(sql);
				ps.setInt(1, order_id);
				ps.setInt(2, book.getBook_id());
				ps.setInt(3, book.getShowppingNums());
				ps.executeUpdate();
			}

			// �ύ���в���
			ct.commit();

		} catch (Exception e) {
			res=false;
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1.getMessage());
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
		return res;
	}

	// �ѹر���Դд�ɺ���
	private void close() {
		// �ر���Դ
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// �׳������쳣
				throw new RuntimeException(e.getMessage());
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// �׳������쳣
				throw new RuntimeException(e.getMessage());
			}
			ps = null;
		}
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// �׳������쳣
				throw new RuntimeException(e.getMessage());
			}
			cs = null;
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// �׳������쳣
				throw new RuntimeException(e.getMessage());
			}
			ct = null;
		}
	}

}
