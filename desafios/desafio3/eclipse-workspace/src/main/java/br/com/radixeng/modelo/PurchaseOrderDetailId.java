package br.com.radixeng.modelo;

import java.io.Serializable;
import java.util.Objects;


public class PurchaseOrderDetailId  implements Serializable {

	private Long PurchaseOrderID; // int PK
	
	private Long PurchaseOrderDetailID; // int AI PK

	public PurchaseOrderDetailId() {
		// Default
	}
		
	public PurchaseOrderDetailId(Long purchaseOrderID, Long purchaseOrderDetailID) {
		PurchaseOrderID = purchaseOrderID;
		PurchaseOrderDetailID = purchaseOrderDetailID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(PurchaseOrderDetailID, PurchaseOrderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrderDetailId other = (PurchaseOrderDetailId) obj;
		return Objects.equals(PurchaseOrderDetailID, other.PurchaseOrderDetailID)
				&& Objects.equals(PurchaseOrderID, other.PurchaseOrderID);
	}

	public Long getPurchaseOrderID() {
		return PurchaseOrderID;
	}

	public void setPurchaseOrderID(Long purchaseOrderID) {
		PurchaseOrderID = purchaseOrderID;
	}

	public Long getPurchaseOrderDetailID() {
		return PurchaseOrderDetailID;
	}

	public void setPurchaseOrderDetailID(Long purchaseOrderDetailID) {
		PurchaseOrderDetailID = purchaseOrderDetailID;
	}
	
	
}
