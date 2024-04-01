This is a program to implement autocomplete for a given set of N terms, where a term is a query string with an associated non-negative weight. 
That is, given a prefix, return all queries starting with that prefix in descending order of weight.

Autocomplete is pervasive in modern applications. As a user types, the program predicts the complete query (typically a word or phrase) they intend to type. 

I implement autocomplete using a Trie. The program will find all query strings (suggestions) starting with a prefix and sort the matching terms by weight or lexicographic order.
