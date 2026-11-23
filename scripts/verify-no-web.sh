#!/data/user/0/ai.antigem/files/usr/bin/bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
bad=0
for pat in "web-portal" "index.html"; do
  if find "$ROOT" -type f -name "*$pat*" | grep -q .; then
    echo "FOUND forbidden web artifact: $pat"; bad=1
  fi
done
for ext in html css js jsx tsx; do
  if find "$ROOT" -type f -name "*.$ext" | grep -q .; then
    echo "FOUND forbidden web file extension: $ext"; bad=1
  fi
done
if grep -R "Razorpay\|Stripe\|Paytm\|PhonePe\|EMI" "$ROOT" --include=*.kt --include=*.cpp --include=*.json 2>/dev/null | grep -q .; then
  echo "FOUND forbidden payment/EMI reference"; bad=1
fi
if [ "$bad" -ne 0 ]; then exit 1; fi
echo "verify-no-web: PASS"