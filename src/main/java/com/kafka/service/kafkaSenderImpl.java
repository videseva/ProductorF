package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import com.kafka.model.Pedido;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;



import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


@SuppressWarnings("deprecation")
@Service
public class kafkaSenderImpl implements KafkaSender {
	@Autowired
	KafkaTemplate kafkaTemplate;

	@Override
	public void sendMessage(String topico, Pedido pedido) {

		ListenableFuture<SendResult<String, Pedido>> future = (ListenableFuture<SendResult<String, Pedido>>) kafkaTemplate.send(topico, pedido);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Pedido>>() {

			@Override
			public void onSuccess(SendResult<String, Pedido> result) {
				System.out.println("resultado");
				/*System.out.println("Enviado " + result.getProducerRecord().value().getProducto() + "al topic"
						+ result.getRecordMetadata().topic());*/

			}

			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();
				System.out.println("fallo");
			}
		});
	}
}