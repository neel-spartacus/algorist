package com.test.codility;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reconciler {

    private static final String STATUS_DONE="done";

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {

        if(Objects.isNull(pending) || Objects.isNull(processed)){
            return Stream.empty();
        }
        else if(!pending.findAny().isPresent() && !processed.findAny().isPresent()){
            return Stream.empty();
        }
        else if(!processed.findAny().isPresent()){
            return pending;
        }
        else if(!pending.findAny().isPresent()){
            return Stream.empty();
        }
        else{
           List<ProcessedTransaction> nonNullProcesses=processed.filter(p-> Objects.nonNull(p)).flatMap(Function.identity()).collect(Collectors.toList());

           List<ProcessedTransaction> completedProcesses=nonNullProcesses.stream().filter(p->(p.getStatus().isPresent()?p.getStatus().get().equalsIgnoreCase(STATUS_DONE):p.getStatus().isPresent())).collect(Collectors.toList());

           List<String> processIds=completedProcesses.stream().filter(processId->(Objects.nonNull(processId.getId())&& !processId.getId().isEmpty())).map(val->val.getId()).collect(Collectors.toList());
           Stream<PendingTransaction> processedPendingTransactions=pending.filter(pendingTransaction->processIds.contains(String.valueOf(pendingTransaction.getId())));
           return Objects.isNull(processedPendingTransactions)?Stream.empty():processedPendingTransactions;
        }
    }
}
