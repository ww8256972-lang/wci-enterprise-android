#!/data/user/0/ai.antigem/files/usr/bin/bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
bad=0
# Allow Firebase Hosting static files under public/
for pat in "web-portal"; do
  if find "$ROOT" -type f -name "*$pat*" -not -path "*/public/*" | grep -q .; then
    echo "FOUND forbidden web artifact: $pat"; bad=1
  fi
done
for ext in html css js jsx tsx; do
  # Permit Firebase Hosting web files under public/
  if find "$ROOT" -type f -name "*.$ext" -not -path "*/public/*" | grep -q .; then
    echo "FOUND forbidden web file extension outside public/: $ext"; bad=1
  fi
done
if grep -R "Razorpay\|Stripe\|Paytm\|PhonePe\|EMI" "$ROOT" --include=*.kt --include=*.cpp --include=*.json --include=*.ts 2>/dev/null | grep -q .; then
  echo "FOUND forbidden payment/EMI reference"; bad=1
fi
if [ "$bad" -ne 0 ]; then exit 1; fi
echo "verify-no-web: PASS (Firebase Hosting public/ allowed)"