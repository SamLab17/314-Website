echo "Creating backup of public_html"
cp -r public_html public_html_backup

echo "Pulling website repo"
git clone https://github.com/SamLab17/314-Website.git 314Website

echo "Copying files into public_html"
cp -r 314Website/public/* public_html/

echo "Fixing file & directory permissions"
(cd public_html; find . -type f -exec chmod 644 {} \; ; find . -type d -exec chmod 755 {} \;)

echo "Cleaning up..."
rm -rf 314Website
