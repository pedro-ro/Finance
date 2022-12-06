package com.finance.demo.ws.conversion.transaction;

import com.finance.demo.domain.transaction.Transaction;
import com.finance.demo.ws.builder.transaction.TransactionDataBuilder;
import com.finance.demo.ws.conversion.ReaderFile;
import lombok.AllArgsConstructor;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TransactionReaderFile extends ReaderFile {

    private List<Transaction> getFrom(File file) {
        Optional.ofNullable(file)
                .map(File::toPath)
                .map(Path::toString)
                .ifPresent(this::init);
        return this.read(1).stream()
                .map(this::from)
                .map(TransactionDataBuilder::getResult)
                .collect(Collectors.toList());
    }

    private TransactionDataBuilder from(String lineTransaction) {
        final String[] columns = lineTransaction.split(SEPARATOR_LINES);
        return TransactionDataBuilder.builder()
                .type(columns[0])
                .date(LocalDate.parse(columns[1], DateTimeFormatter.ofPattern(PATTERN_DATE)))
                .moviment(columns[2])
                .product(columns[3])
                .institution(columns[4])
                .quantity(Long.valueOf(columns[5]))
                .princeUnitary(Double.valueOf(columns[6]))
                .valueOperation(Double.valueOf(columns[7]))
                .build();
    }
}
