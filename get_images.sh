# https://via.placeholder.com/200x200/ff0000/ffffff.jpeg?text=O

BG1='ff0000'
BG2='0000ff'
FG='ffffff'
SIZE='200x200'



for i in O 1 2 3 4 5 6 7 8 9
do
  wget "https://via.placeholder.com/$SIZE/$BG1/$FG.png?text=$i" -O "$BG1-$FG-$i.png"
  wget "https://via.placeholder.com/$SIZE/$BG2/$FG.png?text=$i" -O "$BG2-$FG-$i.png"
done
