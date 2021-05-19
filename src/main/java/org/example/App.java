package org.example;

import org.example.model.AppUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class App 
{
    public static void main( String[] args )
    {
        GenericType<LocalDate> localDateGenericType = new GenericType<>();
        GenericType<Integer> integerGenericType = new GenericType<>();
        integerGenericType.setT(3);
        System.out.println(integerGenericType.getT());

        GenericType type = new GenericType();
        type.setT("fsdfsdf");



        localDateGenericType.setT(LocalDate.now());
        System.out.println(localDateGenericType.getT());


        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.add(BigDecimal.TEN);
        bigDecimals.add(BigDecimal.TEN);

        List<Double> doubles = new ArrayList<>();
        doubles.add(5D);
        doubles.add(10D);

        System.out.println(sum(bigDecimals));
        System.out.println(sum(doubles));

        List<? extends Number> numbers = Arrays.asList(
                5,6,7,8,9.7
        );


        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(new AppUser(5, "johny1", "johny1", null));
        appUsers.add(new AppUser(3, "johny2", "johny2", null));
        appUsers.add(new AppUser(2, "johny3", "johny3", null));
        appUsers.add(new AppUser(1, "johny4", "johny4", null));

        Comparator<AppUser> sortById = new Comparator<AppUser>() {
            @Override
            public int compare(AppUser o1, AppUser o2) {
                return o1.getAppUserId() - o2.getAppUserId();
            }
        };



        List<AppUser> sorted = sortList(appUsers, sortById);

        for(AppUser appUser : sorted){
            System.out.println(appUser);
        }

        sorted = sortList(sorted, new Comparator<AppUser>() {
            @Override
            public int compare(AppUser o1, AppUser o2) {
                return o2.getUsername().compareTo(o1.getUsername());
            }
        });

        System.out.println(sorted);

        Collection<String> strings = findAndReturn(appUsers, appUser -> appUser.getUsername().equals("johny4"), AppUser::getUsername, ArrayList::new);
        System.out.println(strings);

    }

    public static <T> boolean equals(T i, T i1) {
        return i.equals(i1);
    }

    public static double sum(List<? extends Number> numbers){
        double sum = 0;
        for(Number n : numbers){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static <T> List<T> sortList(List<T> source, Comparator<T> comparator){
        source.sort(comparator);
        return source;
    }

    public static<T, R> Collection<R> findAndReturn(
            Collection<T> source,
            Predicate<T> condition,
            Function<T, R> converter,
            Supplier<Collection<R>> supplier)
    {
        return source.stream()
                .filter(condition)
                .map(converter)
                .collect(Collectors.toCollection(supplier));
    }




}
