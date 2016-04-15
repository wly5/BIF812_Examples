#let's declare a class
class Sequence{
  #declare attributes (fields) using has and then the name of the attribute
  has $.seq;
  has $.accession;
  has $!origin;
  
  #normally we don't need to declare a new method (constructor)
  #the new method is inhertied from Mu
  
  #declare a method that will validate the characters in the Sequence
  method validate(){
    #implent this as an exercise
  }
  
  method test(Int $myArg){
    say $myArg;
    say "Hello perl 6, we got a class working.";
    print "some of my attributes are: sequence: " ~ self.seq ~" accession: " ~ self.accession;
  }

}

#let's instantiate our Sequence class
my $mySequence = Sequence.new(seq => "ACGT", accession => "5", origin => "Human");

$mySequence.test(9998);
say "";
say "the perl representation of mySequence is:";
say $mySequence.perl;