# challenge

There are still lots of points are unclear. However, I worte this code in the midnight, I have no chance to ask,
I made such assumption to finish this project:
this project requires to have minimal number of bundles. however, in the test case3:
The output is:
```
13 VID $2370
2 x 5 $1800
1 x 3 $570
```
not 2 X 9., which means it need to consider the optimization, make that do not have much waste.

which make it become a ___'Knapsack problem'___.

also I find the submission file has some miss speeling error,
```
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
15 FLAC
```
my code dose not auto correct this types of error, although it could be easy 
because that will be too many things to check, for example, spelling error(missing only 1 char or 
unnecessary space), capitalization error 
even the wrong format error...

all this I will report Unsupport content or format error.

# Total hours: 

6 hours

(Monday 1h, Friday 5h)
# Limitation: 

I should use csv at first, the string split method is ugly, and I do not know if i should make it
more complex, for example, overwrite the tostring method and provide an interface.
and I also forget how to use log, I forget how to test them.:<

And comments I only provide a few
@author zhicheng xie
@version 0.01
