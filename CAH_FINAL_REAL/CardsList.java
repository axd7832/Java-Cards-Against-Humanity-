import java.util.*;

/**
 * When objects of the class are created, they can be used to send a black
 * or white card to the player.
 * @author Andrew Diana
 * @author Jenna Tillotson
 */
public class CardsList {
   
   Vector<String> whiteCards = new Vector <String>();
   Vector<String> blackCards = new Vector<String>();     
   /** CardsList constructor adds black and white cards
   */
   public CardsList() {
      addWhite();
      addBlack();     
   }
   /** AddWhite adds all the cards to the card array */
   public void addWhite() {
      whiteCards.add("Vigorous jazz hands.");
      whiteCards.add("Flightless birds.");
      whiteCards.add("Doing the right thing.");
      whiteCards.add("The violation of our most basic human rights.");
      whiteCards.add("Self-loathing.");
      whiteCards.add("Spectacular abs.");
      whiteCards.add("A balanced breakfast.");
      whiteCards.add("Roofies.");
      whiteCards.add("The Big Bang.");
      whiteCards.add("Former President George W. Bush.");
      whiteCards.add("The Rev. Dr. Martin Luther King, Jr.");
      whiteCards.add("Cuddling.");
      whiteCards.add("Laying an egg.");
      whiteCards.add("The Pope.");
      whiteCards.add("Fear itself.");
      whiteCards.add("Science.");
      whiteCards.add("Stranger danger.");
      whiteCards.add("Making a pouty face.");
      whiteCards.add("Nickelback.");
      whiteCards.add("Tom Cruise.");
      whiteCards.add("Chainsaws for hands.");
      whiteCards.add("Arnold Schwarzenegger.");
      whiteCards.add("Goblins.");
      whiteCards.add("Object permanence.");
      whiteCards.add("Dying.");
      whiteCards.add("A falcon with a cap on its head.");
      whiteCards.add("Dying of dysentery.");
      whiteCards.add("Pillow fights.");
      whiteCards.add("The invisible hand.");
      whiteCards.add("A really cool hat.");
      whiteCards.add("Sean Penn.");
      whiteCards.add("Men.");
      whiteCards.add("Raptor attacks.");
      whiteCards.add("Agriculture.");
      whiteCards.add("Vikings.");
      whiteCards.add("Pretending to care.");
      whiteCards.add("Being a dick to children.");
      whiteCards.add("Geese.");
      whiteCards.add("Bling.");
      whiteCards.add("Sniffing glue.");
      whiteCards.add("The South.");
      whiteCards.add("An Oedipus complex.");
      whiteCards.add("Eating all of the cookies before the bake-sale.");
      whiteCards.add("YOU MUST CONSTRUCT ADDITIONAL PYLONS.");
      whiteCards.add("Mutually-assured destruction.");
      whiteCards.add("Sunshine and rainbows.");
      whiteCards.add("Count Chocula.");
      whiteCards.add("Being rich.");
      whiteCards.add("Skeletor.");
      whiteCards.add("Michael Jackson.");
      whiteCards.add("Emotions.");
      whiteCards.add("Farting and walking away.");
      whiteCards.add("The Chinese gymnastics team.");
      whiteCards.add("Spontaneous human combustion.");
      whiteCards.add("Leaving an awkward voicemail.");
      whiteCards.add("Dick Cheney.");
      whiteCards.add("Teaching a robot to love.");
      whiteCards.add("Catapults.");
      whiteCards.add("Natural selection.");
      whiteCards.add("Opposable thumbs.");
      whiteCards.add("Figgy pudding.");
      whiteCards.add("Gandhi.");
      whiteCards.add("Preteens.");
      whiteCards.add("Five-Dollar Footlongs.");
      whiteCards.add("Land mines.");
      whiteCards.add("A sea of troubles.");
      whiteCards.add("A zesty breakfast burrito.");
      whiteCards.add("Christopher Walken.");
      whiteCards.add("Friction.");
      whiteCards.add("Balls.");
      whiteCards.add("A can of whoop-ass.");
      whiteCards.add("A tiny horse.");
      whiteCards.add("Authentic Mexican cuisine.");
      whiteCards.add("Genghis Khan.");
      whiteCards.add("Old-people smell.");
      whiteCards.add("The Tempur-Pedic Swedish Sleep System.");
      whiteCards.add("A thermonuclear detonation.");
      whiteCards.add("Take-backsies.");
      whiteCards.add("The Rapture.");
      whiteCards.add("A cooler full of organs.");
      whiteCards.add("Sweet, sweet vengeance.");
      whiteCards.add("RoboCop.");
      whiteCards.add("Keanu Reeves.");
      whiteCards.add("Drinking alone.");
      whiteCards.add("Giving 110%.");
      whiteCards.add("Flesh-eating bacteria.");
      whiteCards.add("The American Dream.");
      whiteCards.add("Taking off your shirt.");
      whiteCards.add("A murder most foul.");
      whiteCards.add("The inevitable heat death of the universe.");
      whiteCards.add("The folly of man.");
      whiteCards.add("That thing that electrocutes your abs.");
      whiteCards.add("Cards Against Humanity.");
      whiteCards.add("Fiery poops.");
      whiteCards.add("Poor people.");
      whiteCards.add("Britney Spears at 55.");
      whiteCards.add("All-you-can-eat shrimp for $4.99.");
      whiteCards.add("Pooping back and forth. Forever.");
      whiteCards.add("Fancy Feast.");
      whiteCards.add("Being a sorcerer.");
      whiteCards.add("Passive-agression.");
      whiteCards.add("Ronald Reagan.");
      whiteCards.add("Full frontal nudity.");
      whiteCards.add("Hulk Hogan.");
      whiteCards.add("Natalie Portman.");
      whiteCards.add("Waking up half-naked in a Denny's parking lot.");
      whiteCards.add("God.");
      whiteCards.add("Sean Connery.");
      whiteCards.add("Saxophone solos.");
      whiteCards.add("The World of Warcraft.");
      whiteCards.add("Darth Vader.");
      whiteCards.add("Hot Pockets.");
      whiteCards.add("A time travel paradox.");
      whiteCards.add("The milk man.");
      whiteCards.add("World peace.");
      whiteCards.add("Licking things to claim them as your own.");
      whiteCards.add("The heart of a child.");
      whiteCards.add("Robert Downey, Jr.");
      whiteCards.add("Lockjaw.");
      whiteCards.add("Eugenics.");
      whiteCards.add("Friendly fire.");
      whiteCards.add("Wearing underwear inside-out to avoid doing laundry.");
      whiteCards.add("Hurricane Katrina.");
      whiteCards.add("Free samples.");
      whiteCards.add("A foul mouth.");
      whiteCards.add("The glass ceiling.");
      whiteCards.add("Republicans.");
      whiteCards.add("Explosions.");
      whiteCards.add("Michelle Obama's arms.");
      whiteCards.add("Getting really high.");
      whiteCards.add("Attitude.");
      whiteCards.add("Sarah Palin.");
      whiteCards.add("My soul.");
      whiteCards.add("Pabst Blue Ribbon.");
      whiteCards.add("Domino's Oreo Dessert Pizza.");
      whiteCards.add("The Blood of Christ.");
      whiteCards.add("A middle-aged man on roller skates.");
      whiteCards.add("Bill Nye the Science Guy.");
      whiteCards.add("Italians.");
      whiteCards.add("Adderall.");
      whiteCards.add("Crippling debt.");
      whiteCards.add("Prancing.");
      whiteCards.add("Passing a kidney stone.");
      whiteCards.add("Puppies!");
      whiteCards.add("Bees?");
      whiteCards.add("Frolicking.");
      whiteCards.add("Repression.");
      whiteCards.add("A bag of magic beans.");
      whiteCards.add("Public ridicule.");
      whiteCards.add("A mime having a stroke.");
      whiteCards.add("Overcompensation.");
      whiteCards.add("Riding off into the sunset.");
      whiteCards.add("Being on fire.");
      whiteCards.add("Tangled Slinkys.");
      whiteCards.add("Being fabulous.");
      whiteCards.add("Shaquille O'Neal's acting career.");
      whiteCards.add("My relationship status.");
      whiteCards.add("Alcoholism.");
      whiteCards.add("Hope.");
      whiteCards.add("Winking at old people.");
      whiteCards.add("Justin Bieber.");
      whiteCards.add("A lifetime of sadness.");
      whiteCards.add("The Hamburglar.");
      whiteCards.add("Swooping.");
      whiteCards.add("Classist undertones.");
      whiteCards.add("New Age music.");
      whiteCards.add("Not giving a shit about the Third World.");
      whiteCards.add("The Kool-Aid Man.");
      whiteCards.add("A hot mess.");
      whiteCards.add("Scientology.");
      whiteCards.add("GoGurt.");
      whiteCards.add("Judge Judy.");
      whiteCards.add("Police brutality.");
      whiteCards.add("When you fart and a little bit comes out.");
      whiteCards.add("Oompa-Loompas.");
      whiteCards.add("Obesity.");
      whiteCards.add("Hot people.");
      whiteCards.add("BATMAN!!!");
      whiteCards.add("A gassy antelope.");
      whiteCards.add("A Super Soaker full of cat pee.");
      whiteCards.add("A disappointing birthday party.");
      whiteCards.add("Nazis.");
      whiteCards.add("A robust mongoloid.");
      whiteCards.add("An M. Night Shyamalan plot twist.");
      whiteCards.add("Getting drunk on mouthwash.");
      whiteCards.add("Lunchables.");
      whiteCards.add("John Wilkes Booth.");
      whiteCards.add("Powerful thighs.");
      whiteCards.add("Multiple stab wounds.");
      whiteCards.add("Kanye West.");
      whiteCards.add("Women's suffrage.");
      whiteCards.add("Children on leashes.");
      whiteCards.add("The Dance of the Sugar Plum Fairy.");
      whiteCards.add("Lance Armstrong's missing testicle.");
      whiteCards.add("Parting the Red Sea.");
      whiteCards.add("Child beauty pageants.");
      whiteCards.add("AXE Body Spray.");
      whiteCards.add("Centaurs.");
      whiteCards.add("Copping a feel.");
      whiteCards.add("Grandma.");
      whiteCards.add("Famine.");
      whiteCards.add("The Trail of Tears.");
      whiteCards.add("The miracle of childbirth.");
      whiteCards.add("Finger painting.");
      whiteCards.add("A monkey smoking a cigar.");
      whiteCards.add("The Make-A-Wish Foundation.");
      whiteCards.add("The Force.");
      whiteCards.add("Kamikaze pilots.");
      whiteCards.add("Dry heaving.");
      whiteCards.add("Active listening.");
      whiteCards.add("Ghosts.");
      whiteCards.add("The Hustle.");
      whiteCards.add("Peeing a little bit.");
      whiteCards.add("Another goddamn vampire movie.");
      whiteCards.add("Shapeshifters.");
      whiteCards.add("Hot cheese.");
      whiteCards.add("A mopey zoo lion.");
      whiteCards.add("A Bop It.");
      whiteCards.add("Expecting a burp and vomiting on the floor.");
      whiteCards.add("Horrifying laser hair removal accidents.");
      whiteCards.add("Boogers.");
      whiteCards.add("Unfathomable stupidity.");
      whiteCards.add("Breaking out into song and dance.");
      whiteCards.add("Soup that is too hot.");
      whiteCards.add("Morgan Freeman's voice.");
      whiteCards.add("Getting naked and watching Nickelodeon.");
      whiteCards.add("The true meaning of Christmas.");
      whiteCards.add("My inner demons.");
      whiteCards.add("Actually taking candy from a baby.");
      whiteCards.add("Crystal meth.");
      whiteCards.add("Exactly what you'd expect.");
      whiteCards.add("Passive-aggressive Post-it notes.");
      whiteCards.add("Inappropriate yodeling.");
      whiteCards.add("Lady Gaga.");
      whiteCards.add("The Little Engine That Could.");
      whiteCards.add("Vigilante justice.");
      whiteCards.add("A death ray.");
      whiteCards.add("Poor life choices.");
      whiteCards.add("A gentle caress of the inner thigh.");
      whiteCards.add("Embryonic stem cells.");
      whiteCards.add("Nicolas Cage.");
      whiteCards.add("Switching to Geico.");
      whiteCards.add("The chronic.");
      whiteCards.add("Home video of Oprah sobbing into a Lean Cuisine.");
      whiteCards.add("A bucket of fish heads.");
      whiteCards.add("Being fat and stupid.");
      whiteCards.add("Getting married, having a few kids, buying some stuff, retiring to Florida, and dying.");
      whiteCards.add("A subscription to Men's Fitness.");
      whiteCards.add("Crucifixion.");
      whiteCards.add("A micropig wearing a tiny raincoat and booties.");
      whiteCards.add("Some god-damn peace and quiet.");
      whiteCards.add("A tribe of warrior women.");
      whiteCards.add("An oversized lollipop.");
      whiteCards.add("Not wearing pants.");
      whiteCards.add("Her Majesty, Queen Elizabeth II.");
      whiteCards.add("Funky fresh rhymes.");
      whiteCards.add("The art of seduction.");
      whiteCards.add("The Devil himself.");
      whiteCards.add("Advice from a wise, old black man.");
      whiteCards.add("Destroying the evidence.");
      whiteCards.add("The light of a billion suns.");
      whiteCards.add("Synergistic management solutions.");
      whiteCards.add("Growing a pair.");
      whiteCards.add("Silence.");
      whiteCards.add("An M16 assault rifle.");
      whiteCards.add("A live studio audience.");
      whiteCards.add("The Great Depression.");
      whiteCards.add("A spastic nerd.");
      whiteCards.add("Capturing Newt Gingrich and forcing him to dance in a monkey suit.");
      whiteCards.add("Battlefield amputations.");
      whiteCards.add("An uppercut.");
      whiteCards.add("Shiny objects.");
      whiteCards.add("An ugly face.");
      whiteCards.add("A bitch slap.");
      whiteCards.add("One trillion dollars.");
      whiteCards.add("The entire Mormon Tabernacle Choir.");
      whiteCards.add("Extremely tight pants.");
      whiteCards.add("The Boy Scouts of America.");
      whiteCards.add("Stormtroopers.");
      whiteCards.add("Gladiatorial combat.");
      whiteCards.add("Good grammar.");
      whiteCards.add("Hipsters.");
      whiteCards.add("Gandalf.");
      whiteCards.add("Genetically engineered super-soldiers.");
      whiteCards.add("George Clooney's musk.");
      whiteCards.add("Getting abducted by Peter Pan.");
      whiteCards.add("Fabricating statistics.");
      whiteCards.add("Finding a skeleton.");
      whiteCards.add("Dancing with a broom.");
      whiteCards.add("Dorito breath.");
      whiteCards.add("One thousand Slim Jims.");
      whiteCards.add("My machete.");
      whiteCards.add("Ominous background music.");
      whiteCards.add("Media coverage.");
      whiteCards.add("Moral ambiguity.");
      whiteCards.add("Medieval Times Dinner & Tournament.");
      whiteCards.add("Mad hacky-sack skills.");
      whiteCards.add("Leveling up.");
      whiteCards.add("Historical revisionism.");
      whiteCards.add("Jean-Claude Van Damme.");
      whiteCards.add("Jafar.");
      whiteCards.add("The economy.");
      whiteCards.add("Statistically validated stereotypes.");
      whiteCards.add("Sudden Poop Explosion Disease.");
      whiteCards.add("Slow motion.");
      whiteCards.add("Space muffins.");
      whiteCards.add("Ryan Gosling riding in on a white horse.");
      whiteCards.add("Pistol-whipping a hostage.");
      whiteCards.add("Quiche.");
      whiteCards.add("Words, words, words.");
      whiteCards.add("Tripping balls.");
      whiteCards.add("Being a busy adult with many important things to do.");
      whiteCards.add("The four arms of Vishnu.");
      whiteCards.add("The shambling corpse of Larry King.");
      whiteCards.add("The hiccups.");
      whiteCards.add("The harsh light of day.");
      whiteCards.add("A beached whale.");
      whiteCards.add("A low standard of living.");
      whiteCards.add("A crappy little hand.");
      whiteCards.add("Being a dinosaur.");
      whiteCards.add("Beating your wives.");
      whiteCards.add("Neil Patrick Harris.");
      whiteCards.add("Carnies.");
      whiteCards.add("Bosnian chicken farmers.");
      whiteCards.add("A web of lies.");
      whiteCards.add("A rival dojo.");
      whiteCards.add("Appreciative snapping.");
      whiteCards.add("Apologizing.");
      whiteCards.add("Clams.");
      whiteCards.add("A woman scorned.");
      whiteCards.add("Spring break!");
      whiteCards.add("Dining with cardboard cutouts of the cast of \"Friends.\"");
      whiteCards.add("A soulful rendition of \"Ol' Man River.\"");
      whiteCards.add("Making a friend.");
      whiteCards.add("The new Radiohead album.");
      whiteCards.add("Pretty Pretty Princess Dress-Up Board Game.");
      whiteCards.add("A man in yoga pants with a ponytail and feather earrings.");
      whiteCards.add("An army of skeletons.");
      whiteCards.add("A squadron of moles wearing aviator goggles.");
      whiteCards.add("Beefin' over turf.");
      whiteCards.add("The Google.");
      whiteCards.add("Bullshit.");
      whiteCards.add("A sweet spaceship.");
      whiteCards.add("Special musical guest, Cher.");
      whiteCards.add("The human body.");
      whiteCards.add("Nunchuck moves.");
      whiteCards.add("Oncoming traffic.");
      whiteCards.add("A dollop of sour cream.");
      whiteCards.add("A slightly shittier parallel universe.");
      whiteCards.add("Power.");
      whiteCards.add("A Burmese tiger pit.");
      whiteCards.add("Basic human decency.");
      whiteCards.add("One Ring to rule them all.");
      whiteCards.add("The day the birds attacked.");
      whiteCards.add("Graphic violence, adult language, and some sexual content.");
      whiteCards.add("The mere concept of Applebee's.");
      whiteCards.add("A sad fat dragon with no friends.");
      whiteCards.add("A piñata full of scorpions.");
      whiteCards.add("Existing.");
      whiteCards.add("Hillary Clinton's death stare.");
      whiteCards.add("Mooing.");
      whiteCards.add("Rising from the grave.");
      whiteCards.add("Subduing a grizzly bear and making her your wife.");
      whiteCards.add("Weapons-grade plutonium.");
      whiteCards.add("All of this blood.");
      whiteCards.add("Tongue.");
      whiteCards.add("Loki, the trickster god.");
      whiteCards.add("Wearing an octopus for a hat.");
      whiteCards.add("An unhinged ferris wheel rolling toward the sea.");
      whiteCards.add("Finding Waldo.");
      whiteCards.add("Living in a trashcan.");
      whiteCards.add("The corporations.");
      whiteCards.add("Jeff Goldblum.");
      whiteCards.add("Me.");
      whiteCards.add("All my friends dying.");
      whiteCards.add("Shutting the hell up.");
      whiteCards.add("Some kind of bird-man.");
      whiteCards.add("The entire Internet.");
      whiteCards.add("Going around punching people.");
      whiteCards.add("A boo-boo.");
      whiteCards.add("Indescribable loneliness.");
      whiteCards.add("Chugging a lava lamp.");
      whiteCards.add("Nothing.");
      whiteCards.add("Samuel L. Jackson.");
      whiteCards.add("The Quesadilla Explosion Salad from Chili's.");
      whiteCards.add("Actually getting shot, for real.");
      whiteCards.add("Dying alone and in pain.");
      whiteCards.add("A cop who is also a dog.");
      whiteCards.add("Jumping out at people.");
      whiteCards.add("Three months in the hole.");
      whiteCards.add("The Land of Chocolate.");
      whiteCards.add("Letting everyone down.");
      whiteCards.add("Having shotguns for legs.");
      whiteCards.add("Mufasa's death scene.");
      whiteCards.add("The Harlem Globetrotters.");
      whiteCards.add("Demonic possession.");
      whiteCards.add("Girls that always be textin'.");
      whiteCards.add("A spontaneous conga line.");
      whiteCards.add("Disco fever.");
      whiteCards.add("Drinking ten 5-hour ENERGYs to get fifty continuous hours of energy.");
      whiteCards.add("Spending lots of money.");
      whiteCards.add("Putting an entire peanut butter and jelly sandwich into the VCR.");
      whiteCards.add("An unstoppable wave of fire ants.");
      whiteCards.add("A greased-up Matthew McConaughey.");
      whiteCards.add("Flying robots that kill people.");
      whiteCards.add("Unlimited soup, salad, and breadsticks.");
      whiteCards.add("Crying into the pages of Sylvia Plath.");
      whiteCards.add("Screaming like a maniac.");
      whiteCards.add("Not contributing to society in any meaningful way.");
      whiteCards.add("Buying the right pants to be cool.");
      whiteCards.add("Roland the Farter, flatulist to the king.");
      whiteCards.add("Eating Tom Selleck's mustache to gain his powers.");
      whiteCards.add("Velcro.");
      whiteCards.add("A PowerPoint presentation.");
      whiteCards.add("Moderate-to-severe joint pain.");
      whiteCards.add("Sugar madness.");
      whiteCards.add("Actual mutants with medical conditions and no superpowers.");
      whiteCards.add("The complex geopolitical quagmire that is the Middle East.");
      whiteCards.add("Neil Diamond's Greatest Hits.");
      whiteCards.add("Whatever a McRib is made of.");
      whiteCards.add("All the single ladies.");
      whiteCards.add("Whispering.");
      whiteCards.add("How awesome I am.");
      whiteCards.add("Smoking crack, for instance.");
      whiteCards.add("Falling into the toilet.");
      whiteCards.add("A hopeless amount of spiders.");
      whiteCards.add("Drinking responsibly.");
      whiteCards.add("Bouncing up and down.");
      whiteCards.add("Ambiguous sarcasm.");
      whiteCards.add("A shiny rock that proves I love you.");
      whiteCards.add("My worthless son.");
      whiteCards.add("Exploding pigeons.");
      whiteCards.add("A Ugandan warlord.");
      whiteCards.add("A kiss on the lips.");
      whiteCards.add("Child Protective Services.");
      whiteCards.add("A Native American who solves crimes by going into the spirit world.");
      whiteCards.add("Doo-doo.");
      whiteCards.add("The peaceful and nonthreatening rise of China.");
      whiteCards.add("Sports.");
      whiteCards.add("Unquestioning obedience.");
      whiteCards.add("Three consecutive seconds of happiness.");
      whiteCards.add("Africa.");
      whiteCards.add("Depression.");
      whiteCards.add("A horse with no legs.");
      whiteCards.add("Khakis.");
      whiteCards.add("Almost giving money to a homeless person.");
      whiteCards.add("Stuffing a child's face with Fun Dip until he starts having fun.");
      whiteCards.add("What Jesus would do.");
      whiteCards.add("A for-real lizard that spits blood from its eyes.");
      whiteCards.add("My dad's dumb face.");
      whiteCards.add("A bunch of idiots playing a card game instead of interacting like normal humans.");
      whiteCards.add("Sharks with legs.");
      whiteCards.add("Too much cocaine.");
      whiteCards.add("Oil!");
      whiteCards.add("A powered exoskeleton.");
      whiteCards.add("A disappointing salad.");
      whiteCards.add("Mom's new boyfriend.");
      whiteCards.add("Denzel.");
      whiteCards.add("Being nine years old.");
      whiteCards.add("The Abercrombie & Fitch lifestyle.");
      whiteCards.add("Vegetarian options.");
      whiteCards.add("A zero-risk way to make $2,000 from home.");
      whiteCards.add("A crazy little thing called love.");
      whiteCards.add("Out-of-this-world bazongas.");
      whiteCards.add("The ghost of Marlon Brando.");
      whiteCards.add("The basic suffering that pervades all of existence.");
      whiteCards.add("Being worshipped as the one true God.");
      whiteCards.add("All these decorative pillows.");
      whiteCards.add("A mouthful of potato salad.");
      whiteCards.add("The passage of time.");
      whiteCards.add("Child support payments.");
      whiteCards.add("Changing a person's mind with logic and facts.");
      whiteCards.add("Genghis Khan's DNA.");
      whiteCards.add("40 acres and a mule.");
      whiteCards.add("Wearing glasses and sounding smart.");
      whiteCards.add("A team of lawyers.");
      whiteCards.add("Getting drive-by shot.");
      whiteCards.add("Not believing in giraffes.");
      whiteCards.add("P.F. Chang himself.");
      whiteCards.add("A one-way ticket to Gary, Indiana.");
      whiteCards.add("Daddy's credit card.");
      whiteCards.add("An unforgettable quinceañera.");
      whiteCards.add("Getting eaten alive by Guy Fieri.");
      whiteCards.add("Western standards of beauty.");
      whiteCards.add("Getting caught by the police and going to jail.");
      whiteCards.add("Free ice cream, yo.");
      whiteCards.add("The white half of Barack Obama.");
      whiteCards.add("The black half of Barack Obama.");
      whiteCards.add("An inability to form meaningful relationships.");
      whiteCards.add("A buttload of candy.");
      whiteCards.add("Bullets.");
      whiteCards.add("A man who is so cool that he rides on a motorcycle.");
      whiteCards.add("Getting all offended.");
      whiteCards.add("Being popular and good at sports.");
      whiteCards.add("A bowl of gourds.");
      whiteCards.add("The male gaze.");
      whiteCards.add("The power of the Dark Side.");
      whiteCards.add("A constant need for validation.");
      whiteCards.add("Like a million alligators.");
      whiteCards.add("Eating together like a god damn family for once.");
      whiteCards.add("Cute boys.");
      whiteCards.add("Being a terrible mother.");
      whiteCards.add("A pizza guy who screwed up.");
      whiteCards.add("The all-new Nissan Pathfinder with 0.9% APR financing!");
      whiteCards.add("A peyote-fueled vision quest.");
      whiteCards.add("Kale.");
      whiteCards.add("Crippling social anxiety.");
      whiteCards.add("Immortality cream.");
      whiteCards.add("Texas.");
      whiteCards.add("A turd.");
      whiteCards.add("Shapes and colors.");
      whiteCards.add("Whatever you wish, mother.");
      whiteCards.add("Robots who just want to party.");
      whiteCards.add("A self-microwaving burrito.");
      whiteCards.add("Forgetting grandma's first name.");
      whiteCards.add("Our new Buffalo Chicken Dippers!");
      whiteCards.add("Treasures beyond your wildest dreams.");
      whiteCards.add("Getting shot out of a cannon.");
      whiteCards.add("Walking into a glass door.");
      whiteCards.add("Every ounce of charisma left in Mick Jagger's tired body.");
      whiteCards.add("The eighth graders.");
      whiteCards.add("The dentist.");
      whiteCards.add("Gwyneth Paltrow's opinions.");
      whiteCards.add("Rabies.");
      whiteCards.add("Important news about Taylor Swift.");
      whiteCards.add("Owls, the perfect predator.");
      whiteCards.add("Being John Malkovich.");
      whiteCards.add("An overwhelming variety of cheeses.");
      whiteCards.add("Reading the entire End-User License Agreement.");
      whiteCards.add("Morpheus.");
      whiteCards.add("Generally having no idea of what's going on.");
      whiteCards.add("No longer finding any Cards Against Humanity card funny.");    
   }
   
   /** addBlack adds all the black cards to the vector */
   public void addBlack() {
      blackCards.add("Why can't I sleep at night?");
      blackCards.add("I got 99 problems but ____ ain't one.");
      blackCards.add("What's a girl's best friend?");
      blackCards.add("What's that smell?");
      blackCards.add("This is the way the world ends / This is the way the world ends / Not with a bang but with ____.");
      blackCards.add("What is Batman's guilty pleasure?");
      blackCards.add("TSA guidelines now prohibit ____ on airplanes.");
      blackCards.add("What ended my last relationship?");
      blackCards.add("I drink to forget ____.");
      blackCards.add("I'm sorry, Professor, but I couldn't complete my homework because of ____.");
      blackCards.add("Alternative medicine is now embracing the curative powers of ____.");
      blackCards.add("What's that sound?");
      blackCards.add("What's the next Happy Meal toy?");
      blackCards.add("It's a pity that kids these days are all getting involved with ____.");
      blackCards.add("Instead of coal, Santa now gives the bad children ____.");
      blackCards.add("Next from J.K. Rowling: Harry Potter and the Chamber of____.");
      blackCards.add("A romantic, candlelit dinner would be incomplete without ____.");
      blackCards.add("____. Betcha can't have just one!");
      blackCards.add("War! What is it good for?");
      blackCards.add("BILLY MAYS HERE FOR ____.");
      blackCards.add("____. High five, bro.");
      blackCards.add("What did I bring back from Mexico?");
      blackCards.add("What are my parents hiding from me?");
      blackCards.add("What would grandma find disturbing, yet oddly charming?");
      blackCards.add("What helps Obama unwind?");
      blackCards.add("Major League Baseball has banned ____ for giving players an unfair advantage.");
      blackCards.add("When I am a billionaire, I shall erect a 50-foot statue to commemorate ____.");
      blackCards.add("What's the new fad diet?");
      blackCards.add("When I am the President of the United States, I will create the Department of ____.");
      blackCards.add("____. It's a trap!");
      blackCards.add("How am I maintaining my relationship status?");
      blackCards.add("What will I bring back in time to convince people that I am a powerful wizard?");
      blackCards.add("Coming to Broadway this season, ____: The Musical.");
      blackCards.add("What's my secret power?");
      blackCards.add("But before I kill you, Mr. Bond, I must show you ____.");
      blackCards.add("What never fails to liven up the party?");
      blackCards.add("What am I giving up for Lent?");
      blackCards.add("What do old people smell like? ");
      blackCards.add("The class field trip was completely ruined by ____.");
      blackCards.add("When Pharaoh remained unmoved, Moses called down a plague of ____.");
      blackCards.add("I do not know with which weapons World War III will be fought, but World War IV will be fought with ____.");
      blackCards.add("What's Teach for America using to inspire inner city students to succeed?");
      blackCards.add("Why do I hurt all over?");
      blackCards.add("Studies show that lab rats navigate mazes 50% faster after being exposed to ____.");
      blackCards.add("Why am I sticky?");
      blackCards.add("What's my anti-drug?");
      blackCards.add("____: Good to the last drop.");
      blackCards.add("____: kid-tested, mother-approved.");
      blackCards.add("What gets better with age?");
      blackCards.add("What's the next superhero/sidekick duo?");
      blackCards.add("Dear Abby, I'm having some trouble with ____ and would like your advice.");
      blackCards.add("After the earthquake, Sean Penn brought ____ to the people of Haiti.");
      blackCards.add("Maybe she's born with it. Maybe it's ____.");
      blackCards.add("Life for American Indians was forever changed when the White Man introduced them to ____.");
      blackCards.add("Next on ESPN2, the World Series of ____.");
      blackCards.add("Here is the church, Here is the steeple, Open the doors, And there is ____.");
      blackCards.add("During his childhood, Salvador Dali produced hundreds of paintings of ____.");
      blackCards.add("In 1,000 years, when paper money is a distant memory, how will we pay for goods and services?");
      blackCards.add("What don't you want to find in your Kung Pao chicken?");
      blackCards.add("The Smithsonian Museum of Natural History has just opened an exhibit on ___."); 
   }
   
   /** sendWhite gets a random card, return the card and remove from list
    * @return send String card to send to the Client
    */
   public String sendWhite() {
      Random r = new Random();
      int wcard = r.nextInt(whiteCards.size());
      String send = whiteCards.get(wcard);
      whiteCards.remove(wcard);
      return send;    
   }
   /** get a random card, retirn and remove from list 
    * @return send String card to send to the Client
    */
   public String sendBlack() {
      Random r = new Random();
      int bcard = r.nextInt(blackCards.size());
      String send = blackCards.get(bcard);
      blackCards.remove(bcard);
      return send;    
   }
}