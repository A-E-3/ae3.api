package ru.myx.ae3.binary;

import ru.myx.ae3.base.BaseObject;

interface BaseTransferBuffer extends BaseObject, TransferBuffer {
	
	@Override
	default BaseObject basePrototype() {
		
		return TransferBuffer.PROTOTYPE;
	}
}
